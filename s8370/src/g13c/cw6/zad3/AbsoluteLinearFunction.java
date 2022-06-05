package g13c.cw6.zad3;

public class AbsoluteLinearFunction extends LinearFunction {

    public AbsoluteLinearFunction(double a, double b) {
        super(a, b);
    }

    @Override
    public double f(double x) {
        return Math.abs(getA()*x+getB());
    }
}
