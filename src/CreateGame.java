import java.util.Scanner;

public class CreateGame {
    private static Scanner scanner = new Scanner(System.in);
    private static Game originalTable = new Game();

    public static void startGame() {
        int n;
        do {
            Menu.showGameMenu();
            originalTable.startGame();
            n = scanner.nextInt();
        } while (n != 2);

        do {
            System.out.print("по горизонталі: ");
            int x = scanner.nextInt();
            System.out.print("по вертикалі: ");
            String y = scanner.next();
            System.out.print("ваше число : ");
            int z = scanner.nextInt();
            originalTable.putNumbers(x, y, z);
        } while (!originalTable.result());
        System.out.println("                                       УРА ПЕРЕМОГА!!!");
        System.exit(0);
    }
}
