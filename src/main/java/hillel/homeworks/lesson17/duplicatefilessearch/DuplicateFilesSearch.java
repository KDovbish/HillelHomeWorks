package hillel.homeworks.lesson17.duplicatefilessearch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.CRC32;

/**
 * Поиск дубликатов файлов в заданной папке *
 */
public class DuplicateFilesSearch {

    private String folderName;
    private List<Entry> files = new ArrayList<>();


    DuplicateFilesSearch(String folderName) {
        this.folderName =  folderName;
    }


    /**
     * Получить список дублирующихся файлов
     * @return Список дублирующихся файлов
     */
    List<Entry> get() {
        //  Внутренний список files заполняется файлами(только файлами!) из папки, переданной в конструктор
        getFiles();

        //  Карта для сохранения результатов группировок
        Map<String, List<Entry>> map;

        //  Заполненный описаниями файлов внутренний список files, группируем по имени и размеру
        map = grouping(e -> e.getName() + e.getSize());
        //  Перезаписываем внутренний список значениями из полученной карты
        //  Т.е. теперь во внутреннем списке теперь будут находяться только описания(Entry) тех файлов, которые имеют дубликаты по имени+размер
        saveMapValues(map);

        //  Вычисляем для всех файлов из внутреннего списка значение CRC и сохраняем его в каждом описании
        setCRC();

        //  Группируем внутренний список по CRC и пересохраняем внутренний список значениями из карты
        map = grouping(e -> e.getCrc().toString());
        saveMapValues(map);

        //  Возвращаем внутренний список
        return files;
    }


    /**
     * Получить CRC файла
     * @param fileName Имя файла
     * @return CRC
     */
    static Long getFileCRC(String fileName) {
        try {
            File file = new File(fileName);
            byte[] data = new byte[(int)file.length()];
            /*
            Длина файла из дескриптора File, отдается как long, но массив byte[], из которого нужно будет сделать ByteBuffer,
            принимает только int. Т.е. данный код ограничен файлами размером чуть больше 2ГБ.
             */

            FileInputStream fis = new FileInputStream(file);
            fis.read(data);
            fis.close();

            CRC32 crc = new CRC32();
            crc.update(ByteBuffer.wrap(data));
            return crc.getValue();
        } catch(IOException e) {
            e.printStackTrace();
            return 0l;
        }
    }


    /**
     * Заполнение внутреннего списка files описаниями файлов(Entry), найденными в
     * папке, имя которой передано в конструкторе(внутреннее поле folderName)
     * @return
     */
    private List<Entry> getFiles() {
        files.clear();
        return getFiles(folderName);
    }

    private List<Entry> getFiles(String folderName) {
        List<Entry> folderContent = getFolderContent(folderName);
        for (Entry e: folderContent) {
            if (e.getIsFolder() ) {
                getFiles(e.getAbsoluteName());
            } else {
                files.add(e);
            }
        }
        return files;
    }

    private List<Entry> getFolderContent(String folderName) {
        List<Entry> list = new ArrayList<>();
        File folder = new File(folderName);
        File[] files = folder.listFiles();
        for (File e: files) {
            list.add( new Entry(e.getName(), e.getAbsolutePath(), e.length(), e.isDirectory()) );
        }
        return list;
    }


    /**
     * Произвести группировку внутреннего списка files по заднному критерию
     * @param f ссылка на функцию отдающую поле(поля) для группировки
     * @return карта <Поле группировки, Список Entry>
     */
    private Map<String, List<Entry>> grouping(Function<Entry, String> f) {
        //  Группировка по заданному полю(полям)...
        Map<String, List<Entry>> map = files.stream()
                .collect(Collectors.groupingBy(f));

        //  Из сформированной карты нужно убрать ключи, которым соответствуют списки с одним значением, т.е. те
        //  у которых нет дубликатов по заданной группировке.
        //  Сначала вычисляем эти ключи, только потом удаляем.
        List<String> keyForDelete = new ArrayList<>();
        //  Поиск ключей и сохранение их в спике keyForDelete
        map.forEach((k, v) ->
        {
            if (v.size() == 1) keyForDelete.add(k);
        });
        //  Проходим по списку keyForDelete и удаляем эти ключи из карты
        keyForDelete.stream().forEach(map::remove);
        return map;
    }


    /**
     * Все значения карты сохранить во внутреннем списке files
     * @param map Карта, чьи значения будут извлечены и прописаны во внутреннем списке
     */
    private List<Entry> saveMapValues(Map<String, List<Entry>> map) {
        Collection<List<Entry>> valueColl = map.values();
        files.clear();
        valueColl.stream().forEach(files::addAll);
        return files;
    }


    /**
     * Вычислить и прописать CRC по всем файлам из внутерннего списка
     * @return Изменный внутренний список
     */
    private List<Entry> setCRC() {
        files.stream().forEach(e -> e.setCrc(DuplicateFilesSearch.getFileCRC(e.getAbsoluteName())));
        return files;
    }

}
