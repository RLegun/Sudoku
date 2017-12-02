import java.util.Scanner;

public class CreateGame {
    private static Scanner scanner = new Scanner(System.in);
    private static UserGame userGame = new UserGame();

    public static void newGame(){

        do {
            userGame.showGame();
            System.out.print("по горизонталі: ");
            int x = scanner.nextInt();
            System.out.print("по вертикалі: ");
            String y = scanner.next();
            System.out.print("поставити число : ");
            int z = scanner.nextInt();
            userGame.putNumber(x,y,z);
        } while (true);
    }
}
