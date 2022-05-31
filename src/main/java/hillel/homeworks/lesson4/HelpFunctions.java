package hillel.homeworks.lesson4;

import java.math.BigDecimal;

public class HelpFunctions {
    /**
     * Сложение двух double-значение с "денежным" огруглением до двух знаков после запятой
     */
    static double add(double a, double b) {
        return new BigDecimal(a+b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Деление двух double-значение с "денежным" огруглением до двух знаков после запятой
     */
    static double mul(double a, double b) {
        return new BigDecimal(a*b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
