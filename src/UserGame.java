import java.util.Arrays;

public class UserGame {
    private final int row = 9;
    private final int col = 9;
    private final int[][] game = new int[row][col];
    private int X = 1;

    public void putNumber(int x, String y, int z){
        String[] ASC = {"A","B","C","D","E","F","G","H","I"};
        game[x-1][Arrays.asList(ASC).indexOf(y)] = z;
    }

    public void showGame() {
        System.out.println("   A B C   D E F   G H I       ваш час: ");
        for (int i = 0; i < game.length; i++) {
            if (i == 3 || i == 6)
                System.out.print(" -------------------------\n");
            System.out.print(X++ + "|");
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(" ");
                if (j == 3 || j == 6) System.out.print("| ");
                System.out.print(game[i][j]);
            }
            System.out.print(" |");
            System.out.println("");
        }
        X = 1;
    }
}
