package g13c.cw6.zad3;

public interface Fun {
    double f(double x);

    static double minimum(Fun func, double a, double b, double alpha) {
        if(a < b) {
            double min = func.f(a);
            double min_tmp = 0;
            for (double i = a; i <= b; i = i + alpha) {
                min_tmp = func.f(i);
                if(min_tmp < min) min = min_tmp;
            }
            return min;
        } else {
            throw new RuntimeException("Parametr A nie może byćwiększy od B");
        }
    }
}