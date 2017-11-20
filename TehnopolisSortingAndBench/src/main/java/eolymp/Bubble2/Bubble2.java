package eolymp.Bubble2;
// https://www.e-olymp.com/ru/problems/4741

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bubble2 {

    public static int bubble(int array[], int size){
        int i,j;
        int count=0;
        int tmp;
        for(i = 0; i<size-1;i++){
            for(j=0;j<size-i-1;j++){
                if(array[j]>array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        final FastScanner scanner = new FastScanner();
        final int size = scanner.nextInt();

        int[] array = new int[size];

        for(int i =0; i<size; i++){
            array[i]= scanner.nextInt();
        }

        System.out.println(bubble(array,size));

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
