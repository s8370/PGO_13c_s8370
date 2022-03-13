package g13c.cw1.zad6;

import java.util.Arrays;

public class zad6 {
    public static void main(String[] args) {
        zad6_sort();
    }

    public static void zad6_sort(){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * (1000 - 100)) + 100);
        }
        System.out.print("Generated array: ");
        arr_printed(arr);
        System.out.println();
        System.out.print("Sorted array: ");
        arr = arr_sorted(arr);
        arr_printed(arr);
    }

    public static void arr_printed(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i+1 < arr.length) System.out.print(", ");
        }
        System.out.print("]");
    }

    public static int[] arr_sorted(int [] arr){
        int[] arr2 = new int[arr.length];
        int mIndex = -1, mValue = -1, lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            mIndex = -1; mValue = -1;
            for (int j = 0; j < arr.length; j++) {
                if((mIndex < 0 && arr[j] > 0) || (arr[j] < mValue && arr[j] > 0)){
                    mIndex = j;
                    mValue = arr[j];
                }
            }
            if(mIndex >= 0){
                arr2[lastIndex] = arr[mIndex];
                arr[mIndex] = -1;
                lastIndex++;
            }

        }
        return arr2;
    }


}
