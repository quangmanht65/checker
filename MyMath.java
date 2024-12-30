public class MyMath {
    public static double sin(double x) {
        double term = x;
        double sum = term;
        int n = 1;
        while (Math.abs(term) > 1e-10) {
            term *= -(x * x) / ((2 * n) * (2 * n + 1));
            sum += term;
            n++;
        }
        return sum;
    }

    public static double cos(double x) {
        double term = 1;
        double sum = term;
        int n = 1;
        while (Math.abs(term) > 1e-10) {
            term *= -(x * x) / ((2 * n - 1) * (2 * n));
            sum += term;
            n++;
        }
        return sum;
    }

    public static double exp(double x) {
        double term = 1;
        double sum = term;
        int n = 1;
        while (Math.abs(term) > 1e-10) {
            term *= x / n;
            sum += term;
            n++;
        }
        return sum;
    }

    public static double ln(double x) {
        if (x <= -1) {
            return -Integer.MAX_VALUE;
        }
        double term = x;
        double sum = term;
        int n = 2;
        while (Math.abs(term) > 1e-10) {
            term *= -x * (n - 1) / n;
            sum += term;
            n++;
        }
        return sum;
    }
}
