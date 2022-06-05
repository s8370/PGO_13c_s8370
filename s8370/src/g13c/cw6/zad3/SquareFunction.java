package g13c.cw6.zad3;

public class SquareFunction extends Function {

    private double a; // Szerokość i kierunek paraboli
    private double b; // Współczynnik przesunięcia osi symetrii
    private double c; // Współczynnik przecięcia y paraboli

    public SquareFunction(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
    }

    @Override
    public double f(double x) {
        return (getA()*x*x+getB()*x+getC());
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        setA(a+delta);
        setB(b+delta);
        setC(c+delta);
    }

    @Override
    void decreaseCoefficientsBy(double delta) {
        setA(a-delta);
        setB(b-delta);
        setC(c-delta);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
