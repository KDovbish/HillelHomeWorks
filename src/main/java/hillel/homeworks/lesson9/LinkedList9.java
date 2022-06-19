package hillel.homeworks.lesson9;


public class LinkedList9 implements Collection{

    //  Сущность, описывающая один элемент данных коллекции
    private class Entry {
        private String data;
        private Entry next;
        Entry(String data) {
            this.data = data;
        }

        @Override
        public String toString() {

            return "data='" + data + "', next='" + ((next==null)?"null":next.data) + "'";

            /*
            return "data='" + data + "\'" +
                    ", next='" +  next==null?"null": next.data  + "\'";

             */
        }
    }

    private Entry first = null;
    private Entry last = null;

    private int size = 0;


    /**
     * Добавить новый элемент в хвост коллекции
     * @param str Строка для добавления
     * @return true
     */
    @Override
    public boolean add(String str) {
        if (size == 0) {
            first = new Entry(str);
            last = first;
        } else {
            //  Создаем новую сущность для элемента данных списка и прописываем в текущем(пока еще!) последнем элементе списка,
            //  ссылку на этот новый объект
            last.next = new Entry(str);
            //  Переключаем "глобальный указатель на последний объект" на только что созданный новый объект с данными
            last = last.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        for (int i = 0; i <= strColl.size() - 1; i ++) {
            add(strColl.get(i));
        }
        return true;
    }

    /**
     * Получить количество элементов в коллекции
     * @return Количество элементов
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Найти элемент с заданным порядковым номером начиная с начала списка(нулевой элемент) и отдать его значене
     * @param index Порядковый номер элемента в списке
     * @return Строка - значение элемента списка либо строка "unknown index" если индекс некорректен
     */
    @Override
    public String get(int index) {
        Entry entry;
        if ((entry = getEntryByIndex(index)) != null) {
            return entry.data;
        } else {
            return "unknown index";
        }
    }

    /**
     * Проверка на наличие в коллекции заданного значения
     * @param str Искомая строка
     * @return true/false - найдена или нет искомая строка
     */
    @Override
    public boolean contains(String str) {
        if (size == 0) return false;
        Entry current = first;
        do {
            if (current.data.equals(str)) {
                break;
            } else {
                current = current.next;
            }
        } while (current != null);
        return (current != null);
    }

    /**
     * Удалить элемент с заданным порядоковым номером
     * @param index Порядковый номер элемента в списке
     * @return true/false - успешно или неуспешно удаление
     */
    @Override
    public boolean delete(int index) {
        //  Случай удаления последнего отавшегося элемента в коллекции
        if (size == 1 && index == 0) {
            first = null;
            last = null;
            size = 0;
            return true;
        }

        //  В коллекции больше одного элемента. Удаляется нулевой элемент
        if (size > 1 && index == 0) {
            first = first.next;
            size--;
            return true;
        }

        //  В коллекции больше одного элемента. Удаляется хвостовой элемент
        if (size > 1 && index == size - 1) {
            Entry previos = getEntryByIndex(index - 1);
            previos.next = null;
            last = previos;
            size--;
            return true;
        }

        //  В коллекции больше одного элемента. Удаляется срединный элемент
        if (size > 1 && index < size - 1) {
            //  Получить ссылку на элемент предыдущий от удаляемого
            Entry previos = getEntryByIndex(index - 1);
            //  Прописать в предыдущем элементе новую ссылку на следующий от него элемент и взять эту ссылку из удаляемомого элемента.
            previos.next = previos.next.next;
            size --;
            return true;
        }

        //  Случай коллекции с нулевым размером
        //  Случай для отрицательного индекса
        //  Случай для индекса выходящего за пределы размера коллекции
        return false;
    }

    /**
     * Уделение элемента с заданным содержимым
     * @param str Искомая строка для удаления
     * @return true/false - успешно или неуспешно удаление
     */
    @Override
    public boolean delete(String str) {

        if (size == 0) return false;

        //  Цикл перебора элементов коллекции для поиска совпадения
        Entry previos =  null;
        Entry current = first;
        do {
            if (current.data.equals(str)) break;
            previos = current;
            current = current.next;
        } while (current != null);

        //  Совпадение не найдено!
        if (current == null) return false;

        //  Случай удаления последнего отавшегося элемента в коллекции
        if (current == first && current == last) {
            first = null;
            last = null;
            size = 0;
            return true;
        }

        //  В коллекции больше одного элемента. Искомый элемент - это нулевой элемент коллекции
        if (current == first && current != last) {
            first = first.next;
            size--;
            return true;
        }

        //  В коллекции больше одного элемента. Искомый элемент - это последний элемент коллекции
        if (current != first && current == last ) {
            previos.next = null;
            last = previos;
            size--;
            return true;
        }

        //  В коллекции больше одного элемента. Искомый элемент - срединный
        previos.next = current.next;
        size--;
        return true;
    }

    /**
     * Удаление всех элементов в коллекции
     * @return true/false
     */
    @Override
    public boolean clear() {
        first = null;
        last = null;
        size = 0;
        return true;
    }

    @Override
    public boolean trim() {
        return true;
    }

    /**
     * Получить ссылку на элемент данных коллекции по порядковому номеру
     * @param index Порядковый номер элемента данных
     * @return ссылка типа Entry на найденный существующий элемент коллекции либо null
     */
    private Entry getEntryByIndex(int index) {
        if (index >= 0 && index <= size - 1) {
            Entry current = first;
            while ( index-- > 0 ) {
                current =  current.next;
            }
            return current;
        } else {
            return null;
        }
    }


    public void debug() {
        System.out.println("\nРазмер списка: " + size());
        System.out.println("first: " + first);
        System.out.println("last: " + last);
        System.out.println("\nКоллекция: ");
        for (int i = 0; i <=  size() - 1; i++) {
            System.out.println(i + ": " + getEntryByIndex(i));
        }
    }


}
