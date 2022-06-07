package hillel.homeworks.lesson6;

public class Subscriber {

    private int id = 0;                  // Идентификатор клиента
    private String lastName = "";        // Имя
    private String firstName = "";       // Фамилия
    private String middleName = "";      // Отчество
    private String city = "";            // Город
    private String telephone = "";       // Телефон
    private String contract = "";        // Номер договора
    private double balans = 0.00d;       // Баланс счета в телефонной кампании
    private int cityTalk = 0;            // Время городских разговоров, в минутах
    private int outsideCityTalk = 0;     // Время межгорода, в минутах
    private float traffic = 0.0f;        // Интернет-траффик, в ГБ


    Subscriber(int id, String lastName, String firstName, String middleName) {
        setId(id);
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);
    }

    Subscriber(int id, String lastName, String firstName, String middleName,
               String city, String telephone, String contract,
               double balans, int cityTalk, int outsideCityTalk, float traffic) {
        this(id, lastName, firstName, middleName);
        setCity(city);
        setTelephone(telephone);
        setContract(contract);
        setBalans(balans);
        setCityTalk(cityTalk);
        setOutsideCityTalk(outsideCityTalk);
        setTraffic(traffic);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public double getBalans() {
        return balans;
    }

    public void setBalans(double balans) {
        this.balans = balans;
    }

    public int getCityTalk() {
        return cityTalk;
    }

    public void setCityTalk(int cityTalk) {
        this.cityTalk = cityTalk;
    }

    public int getOutsideCityTalk() {
        return outsideCityTalk;
    }

    public void setOutsideCityTalk(int outsideCityTalk) {
        this.outsideCityTalk = outsideCityTalk;
    }

    public float getTraffic() {
        return traffic;
    }

    public void setTraffic(float traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", contract='" + contract + '\'' +
                ", balans=" + balans +
                ", cityTalk=" + cityTalk +
                ", outsideCityTalk=" + outsideCityTalk +
                ", traffic=" + traffic +
                '}';
    }
}
