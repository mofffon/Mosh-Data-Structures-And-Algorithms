package pl.lukaszjaskiewicz.sortingAlgorithms.quickSort;

import pl.lukaszjaskiewicz.Utils;

public class QuickSort {

    public static void sort(int[] input){
        sort(0, input.length - 1, input);
    }

    private static void sort(int start, int end, int[] input){

        if(start >= end){
            return;
        }

        int boundary = partition(start, end, input);

        sort(start, boundary - 1, input);
        sort(boundary + 1, end, input);

    }

    private static int partition(int start, int end, int[] input){
        var pivot = input[end];
        var boundary = start - 1;

        for(var i = start; i <= end; i++){
            if(input[i] <= pivot){
                Utils.swap(i, ++boundary, input);
            }
        }

        return boundary;
    }
}
