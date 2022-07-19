package hillel.homeworks.lesson16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int gamesNumber;
        Player player1 = new Player();
        Player player2 = new Player();

        //  Первый игрок
        //  В данном случае, компьютер
        player1.setName("COMPUTER");

        //  Второй игрок
        //  В данном случае, человек
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        player2.setName(scanner.next());

        //  Сколько игр будем играть?
        for(;;) {
            System.out.print("Enter number of games: ");
            if (scanner.hasNextInt()) {
                gamesNumber = scanner.nextInt();
                break;
            } else {
                scanner.next();
                System.out.println("Invalid enter! Repeat, please...");
            }
        }

        //  Процесс игры
        int choicePlayer1, choicePlayer2;
        for (int i = 1; i <= gamesNumber; i++) {
            choicePlayer1 = Game.generateRandomResult();    //  случайный выбор компьютера
            choicePlayer2 = Game.askPlayer();               //  выбор человека
            if (choicePlayer2 != Game.BREAK) {

                System.out.print(player1.getName() + ": " + Game.translateChoice(choicePlayer1) + "  " +
                                    player2.getName() + ": " + Game.translateChoice(choicePlayer2));

                player1.setGamesPlayed(player1.getGamesPlayed() + 1);
                player2.setGamesPlayed(player2.getGamesPlayed() + 1);

                switch (Game.getGameResult(choicePlayer1, choicePlayer2)) {
                    case Game.DRAW :
                        System.out.println("  DRAW");
                        player1.setDraw(player1.getDraw() + 1);
                        player2.setDraw(player2.getDraw() + 1);
                        break;
                    case Game.PLAYER1:
                        System.out.println("  " + player1.getName() + " is win");
                        player1.setWin(player1.getWin() + 1);
                        player2.setLoss(player2.getLoss() + 1);
                        break;
                    case Game.PLAYER2:
                        System.out.println("  " + player2.getName() + " is win");
                        player1.setLoss(player1.getLoss() + 1);
                        player2.setWin(player2.getWin() + 1);
                        break;
                }
            } else {
                break;
            }
        }

        //  Вывод сводных результатов игры
        System.out.println();
        System.out.println(player1);
        System.out.println(player2);

    }
}
