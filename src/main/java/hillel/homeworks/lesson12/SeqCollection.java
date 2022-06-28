package hillel.homeworks.lesson12;

/**
 * Последовательная коллекция
 * Имеет внутреннюю реализацию на базе массива строк. Если в процессе наращивания коллекции клиентом, размера внутреннего
 * массива не хватает, то массив пересоздается с размером большим на размер фиксированного блока.
 * При использовании метода добавления с индексом в качестве параметра, осуществляется сдвиг вправо элементов коллекции справа от
 * заданного индекса. Т.е. коллекция расширяется.
 * При использовани метод удаления с индексом в качестве параметра, осуществляется сдвиг влево элементов коллекции справа от
 * заданного индекса. Т.е коллекция сжимается.
 * Проверка эквивалентности построена на предварительной проверке рефлексии, идентичности размеров коллекций и проверке
 * каждого елемента на null. Только после этого для каждого элемента отрабатывает метод equals().
 */
public class SeqCollection implements Collection {

    //  Размер блока, используемый для строительства внутреннего массива
    private static final int ARRAY_BLOCK_SIZE = 10;

    //  Внутренний физический массив на базе которого строится коллекция
    private String[] array;
    //  индекс, который всегда указывает на ячейку массива для добавления нового элемента
    private int newElementIndex;

    /**
     * Создать пустую коллекцию
     */
    public SeqCollection() {
        array = new String[ARRAY_BLOCK_SIZE];
        newElementIndex = 0;
    }

    /**
     * Создать коллекцию заданного размера
     * Значения у всех элементов созданной коллекции устанавливается по умолчанию null
     * @param size Резмер коллекции
     */
    public SeqCollection(int size) {
        if ( size > 0 ) {
            array =  new String[size];
            newElementIndex = size;
        } else {
            array = new String[ARRAY_BLOCK_SIZE];
            newElementIndex = 0;
        }
    }



    /**
     * Добавить новое значение в ячейку коллекции с заданным индексом.
     * При вставке в центр коллекции, существующие элементы начиная с заданного индекса и правее, сдигаются
     * на один индекс вправо. Размер коллекции увеличивается на единицу. Также возможно добавление по индексу, следуемому
     * за последним элементом. Т.е. в хвост коллекции. В последнем случае, сдвиг вправо не нужен, увеличивается только  размер
     * коллекции.
     * @param index индекс по которому будет производиться добавление
     * @param value Добавляемая строка
     * @return Было ли Успешно/Неуспешно добавление
     */
    public boolean add(int index, String value) {
        //  Заданный индекс находиться в пределах коллекции?
        if (isWithinCollection(index)) {
            //  После сдига вправо, последний элемент коллекции будет находиться в пределах внутреннего массива?
            //  Если нет, то внутренний массив перед сдвигом вправо нужно расширить...
            if (!isWithinArray(size())) {
                expandArray();
            }
            //  Сдвигаем вправо элементы, начиная с заданного индекса
            rightShiftCollection(index);
            //  Вносим в заданный индекс новое значение
            array[index] = value;
        } else {
            //  индекс не находиться в пределах коллекции.
            //  Но может быть он является следующим за последним элементом коллекции?
            if (index == size()) {
                //  Добавление в хвост коллекции
                add(value);
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * Добавить новое значение в хвост коллекции
     * @param value Добавляемая строка
     * @return Было ли Успешно/Неуспешно добавление
     */
    @Override
    public boolean add(String value) {
        if (!isWithinArray(newElementIndex)) {
            expandArray();
        }
        array[newElementIndex] = value;
        newElementIndex++;
        return true;
    }

    /**
     * Найти и удалить заданное значение в коллекции
     * @param value Строка для поиска и удаления
     * @return Успешным или неуспешным было удаление
     */
    @Override
    public boolean delete(String value) {
        int index = getIndexByValue(value);
        if (index != -1) {
            return deleteDataByIndex(index);
        } else {
            return false;
        }
    }

    /**
     * Получить значение элемента коллекции по индексу
     * @param index индекс
     * @return Строка, хранящаяся в элементе с заданным индексом. В случае, если индекс указан некорректно,
     * функция возвращает строку "UNKNOWN INDEX"
     */
    @Override
    public String get(int index) {
        if (isWithinCollection(index)) {
            return array[index];
        } else {
            return "UNKNOWN INDEX";
        }
    }

    /**
     * Содержит ли коллекция, элемент с заданным значением?
     * @param value Искомая строка
     * @return Содержит/Не содержит
     */
    @Override
    public boolean contains(String value) {
        return (getIndexByValue(value)!=-1);
    }


    /**
     * Проверка на эквивалентность с другой коллекцией
     * @param coll Ссылка на другую коллекцию
     * @return Отдает true/false в зависимости о того эквивалентны коллекции или нет
     */
    @Override
    public boolean equals(Collection coll) {
        if (coll == this) return true;
        if (coll.size() != size()) return false;
        for (int i = 0; i <= size() - 1; i++) {
            if ( (coll.get(i) == null && get(i) != null) || (coll.get(i) != null && get(i) == null) ) return false;
            if (coll.get(i) == null && get(i) == null) continue;
            if (coll.get(i).equals(get(i))==false) return false;
        }
        return true;
    }

    /**
     * Очистка коллекции
     * @return
     */
    @Override
    public boolean clear() {
        if (array.length > ARRAY_BLOCK_SIZE) {
            array =  new String[ARRAY_BLOCK_SIZE];
        }
        newElementIndex = 0;
        return true;
    }

    /**
     * Получить размер коллекции
     * @return Размер коллекции
     */
    public int size() {
        return newElementIndex;
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
        return (index >= 0 && index < size());
    }

    /**
     * Указывает ли заданный индекс на последний элемент коллекции?
     * @param index Номер индекса
     * @return true/false
     */
    private boolean isLastCollectionEl(int index) {
        return (index == (size() - 1));
    }

    /**
     * Получить количество свободных ячеек в массиве
     * @return Количество элементов коллекции которые можно еще разместить во внутреннем массиве
     */
    private int getFreeElementsQuantity() {
        return array.length - size();
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
     * При расширении внутреннего массива, источник данных меньше чем приемник.
     * При усечении внутреннего массива, источник данных больше чем приемник, но при усечении лишние данные
     * источника явлются незначимыми.
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
     * Сдвиг коллекции вправо начиная с текущего индекса
     * @param startIndex Стартовый индекс
     */
    private void rightShiftCollection(int startIndex) {
        if (startIndex >= 0 && startIndex < size()) {
            for (int i = size() - 1; i >= startIndex; i --) {
                array[i+1] = array[i];
            }
            //  из-за сдвига вправо коллекция расширилась на один элемент.
            //  индекс по которому теперь можно добавлять новый элемент, также увеличился на единицу.
            newElementIndex ++;
        }
    }

    /**
     * Сдивг коллекции влево начиная с текущего индекса
     * @param startIndex Стартовый индекс
     */
    private void leftShiftCollection(int startIndex) {
        if (startIndex > 0 && startIndex < size()) {
            for (int i = startIndex; i <= size() - 1; i++) {
                array[i - 1] = array[i];
            }
            //  из-за сдига влево коллекция уменьшилась на один элемент
            //  индекс по которому теперь можно добавлять новый элемент, также уменьшился на единицу.
            newElementIndex--;
        }
    }


    /**
     * искать строку в коллекции(не в массиве!). Отдать индекс элемента, в котором храниться строка.
     * @param s искомая строка
     * @return индекс элемента в котором храниться строка либо -1 если строка не найдена
     */
    private int getIndexByValue(String s) {
        if (s == null) {
            for (int i = 0; i <= size() - 1; i++) {
                if (array[i] == null) return i;
            }
        } else {
            for (int i = 0; i <= size() - 1; i++) {
                if (array[i] != null && array[i].equals(s)) return i;
            }
        }
        return -1;
    }


    /**
     * Удаление элемента по заданному индексу
     * @param index Номер индекса
     * @return Успешным ли было удаление? true/false
     */
    protected boolean deleteDataByIndex(int index) {
        //  индекс удаляемого элемента находиться за пределами коллекции?
        if (!isWithinCollection(index)) {
            return false;
        } else {
            //  Если индекс удаляемого элемента явлется не последним индексом в коллекции,
            //  то делаем левый сдвиг в коллекции. Если же последний, то сдиг не нужен. Просто фиксируем
            //  уменьшение коллекции на один элемент.
            if (!isLastCollectionEl(index)) {
                leftShiftCollection(index + 1);
            } else {
                newElementIndex--;
            }
            //  Если количество свободных ячеек во внутреннем массиве больше чем размер строительного блока
            //  этого массива, то усекам внутренний массив на размер блока.
            if (getFreeElementsQuantity()  > ARRAY_BLOCK_SIZE) {
                cutArray();
            }
            return true;
        }
    }

}
