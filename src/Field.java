import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Field {
    private Random rnd = new Random();
    private final int row = 9;
    private final int col = 9;
    private List<Integer> list = new ArrayList<>();
    private int[][] userTable = new int[row][col];
    private int[][] table = new int[row][col];

    public void fillTable(int x, String y, int z) {
        String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        userTable[x - 1][Arrays.asList(ABC).indexOf(y)] = z;
        showUserTable();
    }

    public void fillList() {
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
    }

    public boolean checkCol(int col, int item) {
        for (int i = 0; i < 9; i++) {
            if (table[i][col] == item) return false;
        }
        return true;
    }

    public boolean checkSection(int col, int row, int item) {
        if (row <= 2) row = 0;
        else if (row >= 6) row = 6;
        else row = 3;

        if (col <= 2)col = 0;
        else if (col >= 6)col = 6;
        else col = 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[row][col] == item) return false;
                col++;
            }
            col -= 3;
            row++;
        }
        return true;
    }

    public int checkForOpen(int col, int row, int item) {
        int count = 0;
        if (row <= 2) row = 0;
        else if (row >= 6) row = 6;
        else row = 3;

        if (col <= 2)col = 0;
        else if (col >= 6)col = 6;
        else col = 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (userTable[row][j] == item) count++;
            }
            row++;
            for (int j = 0; j < 9; j++) {
                if (userTable[j][col] == item) count++;
            }
            col++;
        }
        return count;
    }

    public void fillField() {
        fillList();
        int backOneLine = 0;
        int backTwoLine = 0;
        int x = 9;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 9; j++) {
                int ind = rnd.nextInt(x--);
                int N = list.get(ind);
                table[i][j] = N;
                list.remove(ind);
            }
        }
        x = 9;
        fillList();
        int i = 1;
        int j = 0;
        int col = 0;
        int row = 1;

        while (table[8][8] == 0) {
            while (table[i][8] == 0) {
                int ind = rnd.nextInt(x);
                int N = list.get(ind);
                if (checkCol(col, N) && checkSection(col, row, N)) {
                    table[i][j++] = N;
                    col++;
                    x--;
                    list.remove(ind);
                    backOneLine = 0;
                }
                if (backTwoLine > 15) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 9; l++) {
                            table[i][l] = 0;
                        }
                        i--;
                    }
                    list.removeAll(list);
                    fillList();
                    x = 9;
                    j = 0;
                    col = 0;
                    backTwoLine = 0;
                }
                backOneLine++;
                if (backOneLine > 20) {
                    for (int k = 0; k < 9; k++)
                        table[i][k] = 0;
                    list.removeAll(list);
                    fillList();
                    x = 9;
                    j = 0;
                    col = 0;
                    backOneLine = 0;
                    backTwoLine++;
                }
            }
            fillList();
            i++;
            x = 9;
            j = 0;
            col = 0;
            row++;
        }
    }


    public void GenerateUserTable() {
        fillField();
        for (int i = 0; i < userTable.length; i++) {
            for (int j = 0; j < userTable[i].length; j++) {
                userTable[i][j] = table[i][j];
            }
        }
        int x = 9;
        for (int k = 0; k < 9; k++) {
            int ind = rnd.nextInt(x);
            int item = list.get(ind);
            for (int l = 0; l < 9; l++) {
                if (userTable[k][l] == item) {
                    userTable[k][l] = 0;
                    list.remove(ind);
                    x--;
                }
            }
        }
        int open = 0;
        do {
            int i = rnd.nextInt(9);
            int j = rnd.nextInt(9);
            //------------------------------------------
            int temp = userTable[i][j];
            userTable[i][j] = 0;
            if (checkForOpen(j, i, temp) == 4) {
                userTable[i][j] = temp;
            }
            open++;
        } while (open != 81);
        showUserTable();
    }

    public boolean CheckResult() {
        int item = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == userTable[i][j]) item++;
            }
        }
        return item == 81;
    }

    public int[][] getTable() {
        return table;
    }

    public static Field getInstance(){
        return new Field();
    }

    public void showUserTable() {
        int X = 1;
        System.out.println("==========================       гравець: "
                + Session.getPlayer() + "," + "  дата: " + Session.getDate());
        System.out.println(" ~ A B C   D E F   G H I ~       ваш час: 00:00 ");
        for (int i = 0; i < userTable.length; i++) {
            if (i == 3 || i == 6)
                System.out.print(" -------------------------\n");
            System.out.print(X++ + "|");
            for (int j = 0; j < userTable[i].length; j++) {
                System.out.print(" ");
                if (j == 3 || j == 6) System.out.print("| ");
                System.out.print(userTable[i][j]);
            }
            System.out.print(" |");
            System.out.println("");
        }
        System.out.println("==========================");
    }
}
