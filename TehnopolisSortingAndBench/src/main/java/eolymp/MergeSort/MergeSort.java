package eolymp.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.e-olymp.com/ru/submissions/submit?problem=4037

public class MergeSort {


    static Robot[] MergeSort(Robot[] arr, int size){
        Robot[] temp = new Robot[size];
        for(int i =0; i<size;i++){
            temp[i] = new Robot();
        }
        mSort(arr,temp,0,size-1);
        return arr;
    }

    static void mSort(Robot[] arr,Robot[] temp, int start, int end){
        if(start>=end) return;
        int mid = start+(end-start)/2;
        mSort(arr,temp,start,mid);
        mSort(arr,temp,mid+1,end);
        Merge(arr,temp,start,mid,end);
    }

    static void Merge(Robot[] arr, Robot[] temp,int startA,
            int startB,int endB) {
        System.arraycopy(arr, startA, temp, startA, endB + 1 - startA);
        int i = startA;
        int j = startB+1;
        for (int k = startA; k <= endB; k++) {
            if (i > startB) {
                arr[k] = temp[j++];
            } else if (j > endB) {
                arr[k]= temp[i++];
            } else if (temp[i].firstN <= temp[j].firstN) {
                arr[k] = temp[i++];
            } else if (temp[i].firstN > temp[j].firstN) {
                arr[k]= temp[j++];
            }
        }
    }


    static class Robot{
        int firstN;
        int secondN;
        int curPos;
        Robot(){
            firstN=0;
            secondN=0;
            curPos=0;
        }
    }

    public static void main(String[] args) {
        final FastScanner scanner = new FastScanner();
        final int size = scanner.nextInt();
        Robot array[] = new Robot[size];

        for(int i =0; i<size; i++){
            array[i] = new Robot();
            array[i].firstN=scanner.nextInt();
            array[i].secondN=scanner.nextInt();
            array[i].curPos=i;
        }

        MergeSort(array,size);
        printArr(array,size);
        System.out.println(" ");
    }


    static void swap(Robot[] array, int i,int j){
        final Robot tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    static void printArr(Robot array[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i].firstN + " "+array[i].secondN);
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
