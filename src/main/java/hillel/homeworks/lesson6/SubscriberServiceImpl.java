package hillel.homeworks.lesson6;

/**
 * Класс-реализация интерфейса SubscriberService
 * Включает в себя ряд методов, для работы с массивом телефонных абонентов
 */
public class SubscriberServiceImpl implements SubscriberService {

    private Subscriber[] sub;

    SubscriberServiceImpl(Subscriber[] sub) {
        this.sub = sub;
    }

    @Override
    public void getCityTalkMore(int timelimit) {
        System.out.println("\nСписок абонентов, у которых время внутригородских разговоров превышает...: " + timelimit);
        for (Subscriber sub: this.sub) {
            if (sub.getCityTalk() > timelimit) {
                System.out.println(sub);
            }
        }
    }

    @Override
    public void getOutsideCityTalkUse() {
        System.out.println("\nСписок абонентов, которые пользовались междугородней связью");
        for (Subscriber sub: this.sub) {
            if (sub.getOutsideCityTalk() > 0) {
                System.out.println(sub);
            }
        }
    }

    @Override
    public void findByLastNameFirstLetter(String firstLetter) {
        System.out.println("\nСписок абонентов, у которых фамилия начинается с буквы...: " + firstLetter);
        for (Subscriber sub: this.sub) {
            if (sub.getLastName().startsWith(firstLetter)) {
                System.out.println(sub.getLastName() + " " + sub.getFirstName() + " " + sub.getMiddleName() + " " + sub.getTelephone() + " " + sub.getBalans());
            }
        }
    }

    @Override
    public void getAllTrafficByCity(String city) {
        float allTraffic = 0;
        for (Subscriber sub: this.sub) {
            if (sub.getCity().equals(city) ) {
                allTraffic += sub.getTraffic();
            }
        }
        System.out.println("\nСуммарный интернет-траффик по городу " + city + ": " + allTraffic);
    }

    @Override
    public void getNegativeBalansSubQuantity() {
        int quantity = 0;
        for (Subscriber sub: this.sub) {
            if (sub.getBalans() < 0  ) {
                quantity++;
            }
        }
        System.out.println("\nКоличество абонентов с отрицательным балансом: " + quantity);
    }

    /**
     * Распечатать весь массив телефонных абонентов
     */
    public void print() {
        for (Subscriber subscriber: sub) {
            System.out.println(subscriber);
        }
    }

}
