package g13c.cw4.zad2;
import java.util.Arrays;

public class Matrix {
    private static int r_tmp = 0;
    protected static int[][] mtx_tmp;
    protected int[][] mtx;

    protected Matrix() {
        setMtx();
    }
    public int[][] getMtx() {
        return mtx;
    }
    protected void setMtx() {
        mtx = new int[mtx_tmp.length][mtx_tmp[0].length];
        for(int a=0; a< mtx_tmp.length;a++) {
            System.arraycopy(mtx_tmp[a], 0, mtx[a], 0, mtx_tmp[a].length);
        }
        mtx_tmp = new int[0][0];
    }
    @Override
    public String toString() {
        return "Matrix{" +
                "m=" + Arrays.deepToString(mtx) +
                '}';
    }

    // Deklaracja macierzy
    public static void setUpMatrix(int a, int b){
        if(a > 0 && b > 0) {
            r_tmp = a;
            mtx_tmp = new int[a][b];
        } else {
            throw new RuntimeException("Rozmiar macierzy musi być większy od zera");
        }
    }
    public static void insertRow(int[] row){
        if(mtx_tmp.length > 0) {
            if (row.length == mtx_tmp[0].length) {
                if (r_tmp > 0) {
                    System.arraycopy(row, 0, mtx_tmp[mtx_tmp.length - r_tmp], 0, row.length);
                    r_tmp--;
                } else {
                    throw new RuntimeException("Macierz nie może mieć już więcej wierszy");
                }
            } else {
                throw new RuntimeException("Ilość kolumn niezgodna z deklaracją (zadeklarowano: " + mtx_tmp[0].length + ", przesłano: " + row.length);
            }
        } else {
            throw new RuntimeException("Macierz nie może mieć zero wierszy");
        }
    }
    public static Matrix create(){
        if(r_tmp == 0) {
            return new Matrix();
        } else {
            throw new RuntimeException("Nie podano wszystkich wierszy macierzy");
        }
    }

    // Wypisanie macierzy
    public void print() {
        for (int[] row : this.mtx) {
            System.out.print("|");
            for(int c : row){
                System.out.print("\t"+c);
            }
            System.out.println("\t|");
        }
    }

    // Dodawanie i odejmowanie macierzy (this)
    protected void addOrSubtract(Matrix m, boolean add){
        if(this.mtx.length == m.mtx.length && this.mtx[0].length == m.mtx[0].length) {
            for (int a = 0; a < this.mtx.length; a++) {
                for (int b = 0; b < this.mtx[a].length; b++) {
                    if (add)
                        this.mtx[a][b] += m.mtx[a][b];
                    else
                        this.mtx[a][b] -= m.mtx[a][b];
                }
            }
        } else {
            throw new RuntimeException("Wybrane działanie nie jest możliwe, gdyż macierze mają różne wymiary");
        }
    }
    // Dodawanie i odejmowanie macierzy z tworzeniem nowego obiektu
    protected static Matrix addOrSubtract(Matrix m1, Matrix m2, boolean add){
        if(m1.mtx.length == m2.mtx.length && m1.mtx[0].length == m2.mtx[0].length) {
            Matrix.setUpMatrix(m1.mtx.length, m1.mtx[0].length);
            int[] row3;
            for (int[] row : m1.getMtx()){
                row3 = new int[m1.mtx[0].length];
                System.arraycopy(row, 0, row3, 0, row.length);
                Matrix.insertRow(row3);
            }
            Matrix m3 = Matrix.create();
            m3.addOrSubtract(m2, add);
            return m3;
        } else {
            throw new RuntimeException("Wybrane działanie nie jest możliwe, gdyż macierze mają różne wymiary");
        }
    }
    // Metody dodawania i odejmowania
    public Matrix add(Matrix m){
        addOrSubtract(m, true);
        return this;
    }
    public static Matrix add(Matrix m1, Matrix m2){
        return addOrSubtract(m1, m2, true);
    }
    public Matrix subtract(Matrix m){
        addOrSubtract(m, false);
        return this;
    }
    public static Matrix subtract(Matrix m1, Matrix m2){
        return addOrSubtract(m1, m2, false);
    }

    // Mnożenie macierzy
    public static Matrix multiplication(Matrix m1, Matrix m2){
        if(m1.mtx.length > 0 && m1.mtx[0].length > 0 && m2.mtx.length > 0 && m2.mtx[0].length > 0) {
            if (m1.mtx[0].length == m2.mtx.length) {
                Matrix.setUpMatrix(m1.mtx.length, m2.mtx[0].length);
                int[] crow;
                int cval;
                for (int r1 = 0; r1 < m1.mtx.length; r1++) {
                    crow = new int[m2.mtx[0].length];
                    for (int r2 = 0; r2 < m2.mtx[0].length; r2++) {
                        cval = 0;
                        for (int c1 = 0; c1 < m1.mtx[0].length; c1++)
                            cval += m1.mtx[r1][c1] * m2.mtx[c1][r2];
                        crow[r2] = cval;
                    }
                    Matrix.insertRow(crow);
                }
                return Matrix.create();
            } else {
                throw new RuntimeException("Liczba kolumn pierwszej macierzy musi być równa liczbie wierszy drugiej macierzy");
            }
        } else {
            throw new RuntimeException("Macierze nie mogą być puste");
        }
    }
    public Matrix multiplication(Matrix m){
        return multiplication(this, m);
    }
}
