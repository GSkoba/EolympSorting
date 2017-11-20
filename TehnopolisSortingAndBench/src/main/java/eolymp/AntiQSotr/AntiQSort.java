package eolymp.AntiQSotr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntiQSort {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        int size = scanner.nextInt();

        int[] array = new int[size];

        for(int i = 0; i < size; i++){
            array[i] = i+1;
        }
        antiQSotr(array,size);
        printArr(array,size);
    }

    public static void antiQSotr(int[] array, int size){
        for(int i = 2; i< size; i++){
            swap(array,i,i/2);
        }
    }

    private static void swap(int[] array, int i,int j){
        final int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        boolean hasNext() {
            return st.hasMoreTokens();
        }
    }
}
