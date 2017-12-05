import java.util.Arrays;
import java.util.Random;

public class Game {
    private Random rnd = new Random();
    private final int row = 9;
    private final int col = 9;
    private int[][] userTable = new int[row][col];
    private int[][] table = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
    };

    public void putNumbers(int x, String y, int z) {
        String[] ASC = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        userTable[x - 1][Arrays.asList(ASC).indexOf(y)] = z;
        showUserTable();
    }

    public void transformationTable_1() {
        int[][] table = new int[row][col];
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[i].length; j++) {
                table[j][i] = this.table[i][j];
            }
        }
        this.table = table;
    }


    public void transformationTable_2() {

        int r1 = rnd.nextInt(9);
        int r2;
        if (r1 == 2 || r1 == 5) r2 = r1 - 2;
        else if (r1 == 8) r2 = r1 - 2;
        else r2 = r1 + 1;
        int[] row_1 = new int[row];
        int[] row_2 = new int[row];
        int[] col_1 = new int[row];
        int[] col_2 = new int[row];
        for (byte i = 0; i < table.length; i++) {
            row_1[i] = table[r1][i];
            row_2[i] = table[r2][i];
            table[r1][i] = row_2[i];
            table[r2][i] = row_1[i];
        }
        for (int i = 0; i < table.length; i++) {
            col_1[i] = table[i][r1];
            col_2[i] = table[i][r2];
            table[i][r1] = col_2[i];
            table[i][r2] = col_1[i];
        }
    }

    public void transformationTable_3() {
        int r1; int r2;
        if (rnd.nextInt(3) == 1) {
            r1 = 3; r2 = 0;
        } else if (rnd.nextInt(3) == 2) {
            r1 = 6; r2 = 3;
        } else {
            r1 = 0; r2 = 6;
        }
        int[][] row_1 = new int[3][row];
        int[][] row_2 = new int[3][row];
        int[][] col_1 = new int[row][3];
        int[][] col_2 = new int[row][3];
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 9; j++) {
                row_1[i][j] = table[r1][j];
                row_2[i][j] = table[r2][j];
                table[r1][j] = row_2[i][j];
                table[r2][j] = row_1[i][j];
            }
            r1++; r2++;
        }
        r1 -= 3; r2 -= 3;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length-6; j++) {
                col_1[i][j] = table[i][r1];
                col_2[i][j] = table[i][r2];
                table[i][r1] = col_2[i][j];
                table[i][r2] = col_1[i][j];
                r1++;
                r2++;
            }
            r1 -= 3; r2 -= 3;
        }
    }

    public void mixTable() {
        int r = rnd.nextInt(99);
        int x = 0;
        do {
            transformationTable_1();
            transformationTable_2();
            transformationTable_3();
            transformationTable_2();
            transformationTable_1();
            transformationTable_3();
            x++;
        } while (x != r);
    }

    public void startGame() {
        mixTable();
        for (int i = 0; i < userTable.length; i++) {
            for (int j = 0; j < userTable[i].length; j++) {
                userTable[i][j] = table[i][j];
            }
        }
            int open = 0;
        do {
            int i = rnd.nextInt(9);
            int j = rnd.nextInt(9);
            userTable[i][j] = 0;
            open++;
        } while (open!=50);
        showUserTable();
    }

    public boolean result() {
        int item = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j]==userTable[i][j])item++;
            }
        }
        return item == 81;
        //return Arrays.equals(table,userTable);
    }

    public void showUserTable() {
        int X = 1;
        System.out.println("==========================");
        System.out.println(" ~ A B C   D E F   G H I ~       ваш час: 00:00");
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