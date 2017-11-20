package eolymp.QuickSort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// https://www.e-olymp.com/ru/problems/4848

public class QuickSort1 {

    static void quickSort(int[] array,int left,int right){
        if(left<right){
            int size = right-left+1;
            int pivotpt = (left+right)/2;
            int i = left;
            int j = right-1;
            int pivot = array[pivotpt];
            swap(array,pivotpt,right);
            pivotpt = right;

            while (i<j){
                while (i<right-1 && array[i]<pivot){
                    i++;
                }
                while (j>0 && array[j]>pivot){
                    j--;
                }
                if(i<j){
                    swap(array,i++,j--);
                }
            }
            if(i==j && array[i] < array[pivotpt]){
                i++;
            }
            swap(array,i,pivotpt);
            quickSort(array,left,i-1);
            quickSort(array,i+1,right);
        }
    }

    static void quickSort(int[] array,int size){
        quickSort(array,0,size-1);
    }

    private static void swap(int[] array, int i,int j){
        final int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        final int MAX_SIZE = 100000;

        final FastScanner scanner = new FastScanner();
        final int[] array = new int[MAX_SIZE];

        int i=0;

        while (scanner.hasNext()){
            array[i++]=scanner.nextInt();
        }

        quickSort(array,0,i-1);
        printArr(array,i);
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
