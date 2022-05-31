package hillel.homeworks.lesson4;

//  Предполагается, что на каждой остановке идет заправка до полного бака,
//  вне зависимости от того хватает ли бензина до конца пути или нет
public class Main {

    //  Характеристки машины: объем бака
    final static int CAR_TANK_VOLUME = 40;
    //  Характеристики машины: потребление бензина в литрах на 100 км
    final static int CAR_FUEL_CONSUMPTION = 8;

    //  Маршрут(расстояния от старта): Одесса, Кривое озеро, Жашков, Киев
    static int[] route = {0, 170, 320, 460};


    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Должен присутствовать параметр: стоимость топлива в грн за 1 литр");
            return;
        }

        System.out.println("Длина пути: " + route[route.length-1]);

        //  Стоимость топлива за литр(из входных аргументов модуля)
        double fuelCost = Double.valueOf(args[0]).doubleValue();
        System.out.println("Стоимость топилива за 1 литр: " + fuelCost);

        Car car = new Car(CAR_TANK_VOLUME, CAR_FUEL_CONSUMPTION);
        System.out.println("Объем бака в машине: " + CAR_TANK_VOLUME);
        System.out.println("Расход бензина на 100 км: " +  CAR_FUEL_CONSUMPTION);
        System.out.println("Текущий объем бензина в баке: " +  car.getPetrolVolume());

        float allPetrolVolume = car.howmuchRefuel(route[route.length-1]);
        System.out.println("Требуемое количество топлива на весь путь: " + allPetrolVolume);
        System.out.println("Стоимость топлива на весь путь: " + HelpFunctions.mul(allPetrolVolume, fuelCost) + "\n");

        //  Прохождение маршрута...
        float petrolVolume = 0.0f;
        double petrolCost = 0.00d;
        float petrolFilledVolume = 0.0f;
        int segmentLength = 0;
        for (int i = 1; i <= route.length - 1; i++) {

            //  Длина текущего отрезка пути
            segmentLength = route[i] - route[i-1];

            //  Если требуемый объем бензина для прохождения текущего отрезка пути больше объема бака...
            if (car.howmuchFuel(segmentLength) > car.getTankVolume() ) {
                System.out.println("Отрезок маршрута: " + (i-1) + " -> " + i + "  Расстояние: " + (segmentLength) + "  Пройти невозможно: бак слишком мал" );
                break;
            } else {
                //  В начале пути и на каждой остановке заливаем/доливаем полный бак
                //  Подсчитываем объем залитого бензина за весь путь и его полную стоимость
                petrolFilledVolume = car.fillTank();
                petrolVolume =  petrolVolume + petrolFilledVolume;
                petrolCost = HelpFunctions.add(petrolCost, HelpFunctions.mul(petrolFilledVolume, fuelCost));
                //  Поехали...
                car.go(segmentLength);
                System.out.println( (i-1) + "->" + i + "  " + segmentLength + "  Залито бензина: " + petrolFilledVolume +  "  Всего бензина с начала пути: " + petrolVolume + "  Полная стоимость: " + petrolCost);
            }
        }
        System.out.println("Осталось в баке: " + car.getPetrolVolume());
    }

}
