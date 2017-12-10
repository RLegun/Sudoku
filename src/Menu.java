import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    public static void showMenu() throws InputMismatchException {

        newGame();

        do {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Session.newSession();
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

    public static void newGame(){
        System.out.println("=====================");
        System.out.println("СТВОРИТИ НОВУ ГРУ '1'");
        System.out.println("=====================");
    }
}
