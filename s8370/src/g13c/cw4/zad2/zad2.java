package g13c.cw4.zad2;

public class zad2 {
    public static void main(String[] args) {
        Matrix.setUpMatrix(3,3);
        Matrix.insertRow(new int[]{1,2,3});
        Matrix.insertRow(new int[]{4,5,6});
        Matrix.insertRow(new int[]{7,8,9});
        Matrix matrixA = Matrix.create();
        System.out.println("Matrix A:");
        matrixA.print();
        Matrix.setUpMatrix(3,3);
        Matrix.insertRow(new int[]{9,8,7});
        Matrix.insertRow(new int[]{6,5,4});
        Matrix.insertRow(new int[]{3,2,1});
        Matrix matrixB = Matrix.create();
        System.out.println("Matrix B:");
        matrixB.print();
        matrixA.add(matrixB);
        System.out.println("Matrix A after adding B");
        matrixA.print();
        matrixA.subtract(matrixB);
        System.out.println("Matrix A after subtracting B");
        matrixA.print();
        Matrix.setUpMatrix(3,3);
        Matrix.insertRow(new int[]{6,3,2});
        Matrix.insertRow(new int[]{14,5,7});
        Matrix.insertRow(new int[]{27,5,15});
        Matrix matrixC= Matrix.create();
        System.out.println("Matrix (A+B)-C+(A-C)");
        Matrix.add(matrixA,matrixB)
                .subtract(matrixC)
                .add(matrixA.subtract(matrixC))
                .print();

        // MNOŻENIE MACIERZY
        /*
        System.out.println("\n\n#### MNOŻENIE MACIERZY #### ");
        Matrix.setUpMatrix(2,3);
        Matrix.insertRow(new int[]{1,2,3});
        Matrix.insertRow(new int[]{4,5,6});
        Matrix matrix1= Matrix.create();
        System.out.println("\nMacierz X: ");
        matrix1.print();
        Matrix.setUpMatrix(3,4);
        Matrix.insertRow(new int[]{1,2,3,4});
        Matrix.insertRow(new int[]{5,6,7,8});
        Matrix.insertRow(new int[]{9,10,11,12});
        Matrix matrix2= Matrix.create();
        System.out.println("\nMacierz Y: ");
        matrix2.print();
        Matrix matrix3 = matrix1.multiplication(matrix2);
        System.out.println("\nMacierz X * Y: ");
        matrix3.print();
         */
    }
}
