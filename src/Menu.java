import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    public static void showMenu() throws InputMismatchException {

        showMainMenu();

        do {
            System.out.print("--> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CreateGame.newGame();
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

    public static void showMainMenu() {
        System.out.println("****************************************************");
        System.out.println("*                      MENU:                       *");
        System.out.println("****************************************************");
        System.out.println("* 1. СТВОРИТИ НОВУ ГРУ:                            *");
        System.out.println("* 0. вийти із меню:                                *");
        System.out.println("****************************************************");
    }
}
