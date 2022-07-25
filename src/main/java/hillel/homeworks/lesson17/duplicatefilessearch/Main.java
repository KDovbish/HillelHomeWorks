package hillel.homeworks.lesson17.duplicatefilessearch;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("java -jar DuplicateFilesSearch.jar <folder name>");
            return;
        }

        DuplicateFilesSearch dup = new DuplicateFilesSearch(args[0]);
        List<Entry> filesList = dup.get();
        filesList.stream().forEach(System.out::println);

    }
}
