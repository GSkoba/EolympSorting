package eolymp.MethodOfMin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import eolymp.Bubble2.Bubble2;

public class MethodOfMin {

    public static int countOfInversion = 0;

    static void selectionSort(int[] array, int size){
        int currPos = 0;
        for (int i = 0; i <size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                if (currPos == min) {
                    currPos = i;
                    countOfInversion++;
                } else if (currPos == i) {
                    currPos = min;
                    countOfInversion++;
                }
            }
            swap(array, i, min);
        }
    }

    private static void swap(int[] array, int i,int j){
        final int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        final FastScanner scanner = new FastScanner();
        final int size = scanner.nextInt();

        int[] array = new int[size];

        for(int i =0; i<size; i++){
            array[i]= scanner.nextInt();
        }
        selectionSort(array,size);
        System.out.println(countOfInversion);
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
