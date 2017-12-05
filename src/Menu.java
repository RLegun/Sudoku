import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    public static void showMenu() throws InputMismatchException {

        showGameMenu();

        do {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CreateGame.startGame();
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Not the right choice!");
            }

        } while (choice != 0);
        System.exit(0);
    }

    public static void showGameMenu() {
        System.out.println("=====================================");
        System.out.println(" ВИБРАТИ ГРУ '1' : ЗАПУСТИТИ ГРУ '2' ");
        System.out.println("=====================================");
    }
}
