package eolymp.CountSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.e-olymp.com/ru/problems/2327

public class CountSort {

    static void countingSort(int[] arr, int size){
       int k = findMax(arr);
       int[] c = new int[k+1];

       for(int i =0; i<=k;i++){
           c[i] = 0;
       }

       for(int i =0; i<size;i++){
           c[arr[i]]++;
       }
       int b = 0;
        for(int j =0; j<=k;j++){
            for(int i =0; i<c[j];i++){
                arr[b] = j;
                b++;
            }
        }

    }

    private static int findMin(int[] arr) {
        int min = 0;
        for(int x:arr){
            min=Math.min(min,x);
        }
        return min;
    }

    static int findMax(int[] arr){
        int max = 0;
        for(int x:arr){
            max=Math.max(max,x);
        }
        return max;
    }

    public static void main(String[] args) {
        final FastScanner scanner = new FastScanner();
        final int size = scanner.nextInt();

        int[] array = new int[size];

        for(int i=0;i<size;i++){
            array[i]=scanner.nextInt();
        }

        countingSort(array,size);
        printArr(array,size);
    }

    static void printArr(int array[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
