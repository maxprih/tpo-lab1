package task1;

/**
 * @author max_pri
 */
public class Arctg {
    public static double arctg(double x) {
        double result = 0;
        double sign = 1;
        for (int i = 1; i <= 19; i += 2) {
            double term = sign * Math.pow(x, i) / i;
            result += term;
            sign = -sign;
        }
        return result;
    }
}
