package hillel.homeworks.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> symbList = new ArrayList<>();
        for (int i = 0; i <= args.length - 2; i ++) {
            symbList.add(args[i]);
            symbList.add(" ");
        }
        symbList.add(args[args.length - 1]);

        ConsoleOutputLine line = new ConsoleOutputLine(symbList);

        for (int row = 0; row <= 4; row++) {
            line.getMatrixLineList(row).stream().forEach(System.out::print);
            System.out.println();
        }






        /*
        List<String[]> matrixList = symbList.stream()
                .map(e -> e.charAt(0))
                .map(e -> SymbolTable.getSymbolMatrix(e))
                .toList();


        Stream<String[]> matrixStream = matrixList.stream();
        for (int row = 0; row <= 4; row++){
            matrixStream
                    .map(e -> e[row])
                    .toList();
        }




        List<String> rowList = matrixList.stream()
                .map((e) -> e[0])
                .toList();
         */







        /*
        for (int row = 0; row <= 4; row++) {
            for (int i = 0; i <= matrixList.size() - 1; i++) {
                System.out.print(matrixList.get(i)[row]);
            }
            System.out.println();
        }
         */



        /*
        Stream<String[]> stream = matrixList.stream();
        for (int i = 0; i <= 4; i++) {
            stream.map(e -> e[i]).forEach(System.out::print);
        }
         */




        /*
        matrixList.stream()
                .map(e -> Arrays.toString(e))
                .forEach(System.out::println);
         */





    }
}
