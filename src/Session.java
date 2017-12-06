import java.time.LocalDate;
import java.util.Scanner;

public class Session {
    private static Scanner scanner = new Scanner(System.in);
    private static Game game = new Game(new Field(), new Player());
    private static LocalDate date = LocalDate.now();

    public static void newSession(){
        Menu.newPlayer();
        game.getPlayer().setName(scanner.next());
        startGame();
    }

    public static void startGame() {
        int n;
        do {
            Menu.showGameMenu();
            game.getField().GenerateUserTable();
            n = scanner.nextInt();
        } while (n != 2);

        do {
            System.out.print("по горизонталі: ");
            int x = scanner.nextInt();
            System.out.print("по вертикалі: ");
            String y = scanner.next();
            System.out.print("ваше число : ");
            int z = scanner.nextInt();
            game.getField().fillTable(x, y, z);
        } while (!game.getField().CheckResult());
        System.out.println("                                       УРА ПЕРЕМОГА!!!");
        System.exit(0);
    }

    public static String getPlayer() {
        return game.getPlayer().getName();
    }

    public static LocalDate getDate() {
        return date;
    }
}
