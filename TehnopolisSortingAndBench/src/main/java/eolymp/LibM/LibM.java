package eolymp.LibM;

// https://www.e-olymp.com/ru/problems/2664

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LibM {

    static void insertionSort(int array[], int size){

        int curr;
        int i,j;
        boolean wasSwap = false;
        for(i=0;i<size;i++){
            curr=array[i];

            for(j=i;j>0 && array[j-1] > curr;j--){
                array[j]=array[j-1];
                wasSwap = true;
            }

            array[j]=curr;
            if(wasSwap) {
                printArr(array, size);
                System.out.print("\n");
            }
            wasSwap =false;
        }
    }

    static void printArr(int array[], int size){
        for(int i =0; i< size; i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        final FastScanner scanner = new FastScanner();
        final int size = scanner.nextInt();

        int[] array = new int[size];

        for(int i =0;i<size;i++){
            array[i] = scanner.nextInt();
        }

        insertionSort(array,size);
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
