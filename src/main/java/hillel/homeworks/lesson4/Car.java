package hillel.homeworks.lesson4;

public class Car {
    /** Объем бака */
    private int tankVolume = 0;
    /** Расход топлива в литрах на 100 км */
    private int fuelConsumption;
    /** Текущее количество(объем) бензина в баке */
    private float petrolVolume = 0.0f;

    /**
     * Конструктор
     * @param volume Объем бака
     * @param consumption Расход топлива в литрах на 100 км
     */
    Car(int volume, int consumption) {
        tankVolume = volume;
        fuelConsumption = consumption;
    }


    public float getPetrolVolume() {
        return petrolVolume;
    }

    public int getTankVolume() {
        return tankVolume;
    }


    /**
     * Сколько нужно всего топлива(в целых литрах) чтобы пройти заданное расстояние?
     * @param length Длина пути, которую нужно покрыть
     * @return Количество требуемого топлива
     */
    public int howmuchFuel(int length) {
        /*
        Выполнение выражения в скобках возвращает double, т.е. вычисляется абсолютно точное значение объема требуемого топлива
        Огругляем double в большую сторону, чтобы топлива однозначно хватило на заданный путь
        Преобразовываем в int, т.е. отбрасывается дробную часть, чтобы получить целые значения литров
         */
        return (int) Math.ceil((double)length * fuelConsumption / 100);
    }


    /**
     * Сколько нужно долить топлива(точное значение) в бак, чтобы пройти заданное расстояние?
     * @param length Длина пути, которую нужно покрыть
     * @return Количество требуемого топлива для доливки
     */
    public float howmuchRefuel(int length) {
        int allPetrolVolume = howmuchFuel(length);
        return (allPetrolVolume<=petrolVolume) ? 0 : allPetrolVolume - petrolVolume;
    }

    /**
     * Залить полный бак, с учетом текущего состояния бака
     * @return Объем долитого бензина
     */
    public float fillTank() {
        float currPetrolVolume = petrolVolume;
        petrolVolume = tankVolume;
        return tankVolume - currPetrolVolume;
    }

    /**
     * Машина едет заданную длину пути, расходует бензин
     * @param length Длина пути
     */
    public void go(int length) {
        //petrolVolume = petrolVolume - ((float)length * fuelConsumption / 100);
        petrolVolume = getPetrolRemainder(length);
    }

    /**
     * Определить остаток топлива после прохождения заданный длины пути
     * @param length Длина пути
     * @return Остаток бензина в баке
     */
    public float getPetrolRemainder(int length) {
        return petrolVolume - ((float)length * fuelConsumption / 100);
    }


}
