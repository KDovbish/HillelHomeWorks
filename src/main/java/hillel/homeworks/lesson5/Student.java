package hillel.homeworks.lesson5;

public class Student {

    //  Генерация уникального кода для каждого экземпляра класса
    private static int genId = 0;

    private int id;                      //  Уникальный номер студента в списке
    private String lastName = "";        //  Фамилия
    private String firstName = "";       //  Имя
    private String middleName = "";      //  Отчество
    private int birthYear;               //  Год рождения
    private String address = "";         //  Адрес
    private String telephone = "";       //  Телефон
    private String faculty =  "";        //  Факультет
    private int classNumber;             //  Курс
    private String group = "";           //  Группа


    Student(String lastName, String firstName) {
        setId(++genId);
        setLastName(lastName);
        setFirstName(firstName);
    }

    Student(String lastName, String firstName, String middleName,
                int birthYear, String address, String telephone) {
        this(lastName, firstName);
        setMiddleName(middleName);
        setBirthYear(birthYear);
        setAddress(address);
        setTelephone(telephone);
    }

    Student(String lastName, String firstName,
                String middleName, int birthYear, String address, String telephone,
                String faculty, int classNumber, String group) {
        this(lastName, firstName, middleName, birthYear, address, telephone);
        setFaculty(faculty);
        setClassNumber(classNumber);
        setGroup(group);
    }

    private void setId(int id) {
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthYear='" + ( (birthYear == 0 ) ? "" : birthYear ) + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", faculty='" + faculty + '\'' +
                ", classNumber='" + ( (classNumber == 0 ) ? "" : classNumber ) + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
