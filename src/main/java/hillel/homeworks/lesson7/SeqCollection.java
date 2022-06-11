package hillel.homeworks.lesson7;

/**
 * Последовательная коллекция
 * <p>
 * Ключевая логика коллекции:
 * <p>
 * Добавление нового элемента в коллекцию осуществляется всегда в хвост коллекции.
 * Метод добавления, в который передается и индекс и значение, следует рассматривать как метод корректировки коллекции.
 * Исключением является только добавление нового елемента по индексу следующему за уже существующим последним элементом коллекции.
 * Добавление нового элемента по индексу за пределами длины коллекции с автоматическим созданием пустых элементов слева от добавляемого,
 * в данной реализации коллекции не рассматривается. В последем случае метод вернет false, заявляя тем самым, о невозможности
 * добавления элемента с подобным индексом.
 * <p>
 * Удаление из коллекции "сжимает" коллекцию, т.е. индексы всех элементов справа от удаляемого, уменьшаются на единицу и
 * размер коллекции также уменьшается на единицу. Исключением является только удаление последнего элемента коллекции.
 * В этом случае индексы существующих элементов не меняются.
 * Если в метод удаления индекс не передается, а передется только значение, то удаляется первый найденный элемент с подобным
 * значением. Логика "сжатия" коллекции в этом случае, аналогична описанному выше.
 * <p>
 * Для метода получения значения по индексу следует указывать индексы в пределах длины коллекции. В случае если индекс
 * выходит за пределы коллекции, то будет возвращена строка "UNKNOWN INDEX"
 */
public class SeqCollection implements Collection {

    //  Размер блока, используемый для строительства внутреннего массива(для разработчиков)
    private static final int ARRAY_BLOCK_SIZE = 10;

    //  Внутренний физический массив на базе которого строится коллекция
    private String[] array;
    //  Индекс, который всегда указывает на ячейку массива для добавления нового элемента
    private int addNewDataIndex;


    /**
     * Создать пустую коллекцию
     */
    SeqCollection() {
        array = new String[ARRAY_BLOCK_SIZE];
        addNewDataIndex = 0;
    }

    /**
     * Создать коллекцию заданного размера
     * Значения у всех элементов созданной коллекции устанавливается по умолчанию null
     * @param size Резмер коллекции
     */
    SeqCollection(int size) {
        if (size > ARRAY_BLOCK_SIZE) {
            array = new String[(size / ARRAY_BLOCK_SIZE + ((size % ARRAY_BLOCK_SIZE) > 0 ? 1 : 0)) * ARRAY_BLOCK_SIZE];
        } else {
            array = new String[ARRAY_BLOCK_SIZE];
        }
        addNewDataIndex = size;
    }


    @Override
    public boolean add(int index, String value) {
        return addDataByIndex(index, value);
    }

    @Override
    public boolean add(String value) {
        return addDataByIndex(addNewDataIndex, value);
    }

    @Override
    public boolean delete(int index) {
        return deleteDataByIndex(index);
    }

    @Override
    public boolean delete(String value) {
        int index = getIndexByValue(value);
        if (index != -1) {
            return deleteDataByIndex(index);
        } else {
            return false;
        }
    }

    @Override
    public String get(int index) {
        if (isWithinCollection(index)) {
            return array[index];
        } else {
            return "UNKNOWN INDEX";
        }
    }


    /**
     * Находиться ли заданный индекс в пределах физического массива?
     * @param index Номер индекса
     * @return true/false
     */
    private boolean isWithinArray(int index) {
        return (index >= 0 && index < array.length);
    }

    /**
     * Находиться ли заданный индекс в пределах коллекции?
     * @param index Номер индекса
     * @return true/false
     */
    private boolean isWithinCollection(int index) {
        return (index >= 0 && index < addNewDataIndex);
    }

    /**
     * Указывает ли заданный индекс на последний элемент коллекции?
     * @param index Номер индекса
     * @return true/false
     */
    private boolean isLastCollectionEl(int index) {
        return (index == (addNewDataIndex - 1));
    }

    /**
     * Получить количество свободных ячеек в массиве
     * @return Количество элементов коллекции которые можно еще разместить во внутреннем массиве
     */
    private int getFreeElementsQuantity() {
        return array.length - addNewDataIndex;
    }

    /**
     * Расширить физический массив на один блок
     */
    private void expandArray() {
        String[] newArray = new String[array.length + ARRAY_BLOCK_SIZE];
        copyArray(array, newArray);
        array = newArray;
    }

    /**
     * Уменьшить физический массив на один блок
     */
    private void cutArray() {
        String[] newArray = new String[array.length - ARRAY_BLOCK_SIZE];
        copyArray(array, newArray);
        array = newArray;
    }

    /**
     * Копирование данных из одного массива в другой.
     * Если источник данных имеет длину большую чем приемник, копируется столько элементов, сколько войдет в приемник.
     * При расширении внутреннего массива, источник данных меньше чем приемник. {@link SeqCollection#addNewData(String) Пример расширения внутреннего массива}
     * При усечении внутреннего массива, источник данных больше чем приемник, но при усечении лишние данные
     * источника явлются незначимыми. {@link SeqCollection#deleteDataByIndex(int) Пример усечения внутреннего массива}
     * @param src  Массив-источник данных
     * @param dest Массив-приемник данных
     */
    private void copyArray(String[] src, String[] dest) {
        int copyLimit = dest.length >= src.length ? src.length - 1 : dest.length - 1;
        for (int i = 0; i <= copyLimit; i++) {
            dest[i] = src[i];
        }
    }


    /**
     * Добавление новых данных в конец коллекции
     * @param value Строка для добавления
     */
    private void addNewData(String value) {
        if (isWithinArray(addNewDataIndex) == false) {
            expandArray();
        }
        array[addNewDataIndex] = value;
        addNewDataIndex++;
    }

    /**
     * Добавление данных в коллекцию по заданному индексу
     * @param index Номер индекса
     * @param value Строка для добавления
     */
    private boolean addDataByIndex(int index, String value) {
        if (isWithinCollection(index)) {
            array[index] = value;
        } else {
            if (index == addNewDataIndex) {
                addNewData(value);
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * Переместить все элементы коллекции(не массива!), начиная с заданного индекса, на один индекс влево
     * @param startIndex Стартовый индекс
     */
    private void leftShiftCollection(int startIndex) {
        if (startIndex > 0) {
            for (int i = startIndex; i <= addNewDataIndex - 1; i++) {
                array[i - 1] = array[i];
            }
        }
    }

    /**
     * Удаление элемента по заданному индексу
     * @param index Номер индекса
     * @return Успешным ли было удаление? true/false
     */
    private boolean deleteDataByIndex(int index) {
        if (isWithinCollection(index) == false) {
            return false;
        } else {
            if (isLastCollectionEl(index) == false) {
                leftShiftCollection(index + 1);
            }
            addNewDataIndex--;
            //  Блок проверки на необходимость уменьшения физического массива после удаление элемента коллекции
            if (getFreeElementsQuantity()  > ARRAY_BLOCK_SIZE) {
                cutArray();
            }
            return true;
        }
    }

    /**
     * Искать строку в коллекции(не в массиве!). Отдать индекс элемента, в котором храниться строка.
     * @param s искомая строка
     * @return индекс элемента в котором храниться строка либо -1 если строка не найдена
     */
    private int getIndexByValue(String s) {
        if (s == null) {
            for (int i = 0; i <= addNewDataIndex - 1; i++) {
                if (array[i] == null) return i;
            }
        } else {
            for (int i = 0; i <= addNewDataIndex - 1; i++) {
                if (array[i] != null && array[i].equals(s)) return i;
            }
        }
        return -1;
    }


    /*
    public void debug() {
        System.out.println("Размер внутреннего массива: " + array.length);
        System.out.println("Размер коллекции: " + addNewDataIndex);
        System.out.println("Количество свободных элементов в массиве : " + getFreeElementsQuantity());

        System.out.println("\nМассив:");
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println(i + ": " + array[i]);
        }

        System.out.println("\nКоллекция:");
        for (int i = 0; i <= addNewDataIndex - 1; i++) {
            System.out.println(i + ": " + array[i]);
        }

    }
    */

}
