import java.time.LocalDate;
import java.util.Scanner;

public class Session {
    private static Scanner scanner = new Scanner(System.in);
    private static Game game = new Game(Field.getInstance(), Player.getInstance());
    private static LocalDate date = LocalDate.now();

    public static void newSession(){
        System.out.println("=================");
        System.out.println("<<НОВИЙ ГРАВЕЦЬ>>");
        System.out.println("=================");
        System.out.print("Введіть ваше ім'я: ");
        game.getPlayer().setName(scanner.next());
        startGame();
    }

    public static void startGame() {
        int n;
        do {
            int [][] table = game.getField().getTable();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    table[i][j] = 0;
                }
            }
            System.out.println("=====================================");
            System.out.println(" ВИБРАТИ ГРУ '1' : ЗАПУСТИТИ ГРУ '2' ");
            System.out.println("=====================================");
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
