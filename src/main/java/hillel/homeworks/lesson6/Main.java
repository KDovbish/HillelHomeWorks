package hillel.homeworks.lesson6;

public class Main {
    public static void main(String[] args) {
        SubscriberServiceImpl service = new SubscriberServiceImpl(DataGenerator.getSubsciberArr());
        //service.print();
        service.getCityTalkMore(30);
        service.getOutsideCityTalkUse();
        service.findByLastNameFirstLetter("И");
        service.getAllTrafficByCity("Киев");
        service.getNegativeBalansSubQuantity();
    }
}
