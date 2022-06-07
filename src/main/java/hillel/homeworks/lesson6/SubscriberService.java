package hillel.homeworks.lesson6;

/**
 * Интерфейс сервисных методов для массива телефонных абонентов
 */
public interface SubscriberService {

    /**
     * Получить список абонентов, у которых время внутригородских разговоров превышает заданный лимит
     * @param timelimit Временной лимит на внутригородские разговоры
     */
    void getCityTalkMore(int timelimit);

    /**
     * Получить список абонентов, которые пользовались междугородней связью
     */
    void getOutsideCityTalkUse();

    /**
     * Получить список абонентов в кастомизированном формате для абонентов с заданной первой буквой фамилии
     * @param firstLetter Первая буква фамилии
     */
    void findByLastNameFirstLetter(String firstLetter);

    /**
     * Распечатать суммарный интернет-траффик по заданного городу
     * @param city Город
     */
    void getAllTrafficByCity(String city);

    /**
     * Распечатать количество абонентов с отрицательным балансом
     */
    void getNegativeBalansSubQuantity();
}
