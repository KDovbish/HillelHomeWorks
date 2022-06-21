package hillel.homeworks.lesson10;

import java.util.ArrayList;

/**
 * Квадратное уравнение
 */
public class QuadEquation {

    private double a;
    private double b;
    private double c;
    private double discriminant;

    QuadEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        discriminant = Math.pow(b, 2) - 4 * a * c;
    }

    /**
     * Получить корни квадратного уравнения
     * @return Контейнер ArrayList, содержащий корни уравнения
     */
    public ArrayList<Double> getRoots() {

        ArrayList<Double> roots = new ArrayList<>();

        if (discriminant > 0) {
            roots.add( ((0 - b) + Math.sqrt(discriminant))/(2 * a) );
            roots.add( ((0 - b) - Math.sqrt(discriminant))/(2 * a) );
        } else if (discriminant == 0) {
            roots.add(0 - b / 2 * a);
        }

        return roots;
    }

    /**
     * Получить дискриминант
     * @return
     */
    public double getDiscriminant() {
        return discriminant;
    }

}
