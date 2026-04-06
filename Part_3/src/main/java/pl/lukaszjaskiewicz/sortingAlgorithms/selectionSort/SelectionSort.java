package pl.lukaszjaskiewicz.sortingAlgorithms.selectionSort;

import pl.lukaszjaskiewicz.Utils;

public class SelectionSort {

    public static void sort(int[] input){

        for(int i = 0 ; i < input.length; i++){
            int minIndex = findMinIndex(i, input.length - 1, input);
            Utils.swap(minIndex, i, input);
        }
    }

    private static int findMinIndex(int left, int right, int[] arr){

        int min = Integer.MAX_VALUE;
        int index = -1;

        for(int i = left; i <= right; i++){
            if(arr[i] < min){
                index = i;
                min = arr[i];
            }
        }

        return index;
    }
}
