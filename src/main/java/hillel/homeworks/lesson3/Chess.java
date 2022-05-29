package hillel.homeworks.lesson3;

public class Chess {
    public static void main(String[] args) {
        System.out.println("Урок 3. ДЗ 12. Вывести на экран шахматную доску 8х8 в виде 2 мерного массива (W - белые клетки , B - черные клети)");

        char[] [] chessArr = {
                              {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                              {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                              {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                              {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                              {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                              {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                              {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                              {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                             };

        for (int i = 0; i <= chessArr.length-1; i++) {
            for (int j = 0; j <= chessArr[i].length-1; j++) {
                System.out.print(chessArr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
