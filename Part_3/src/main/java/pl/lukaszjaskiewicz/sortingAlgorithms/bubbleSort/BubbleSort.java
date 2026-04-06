package pl.lukaszjaskiewicz.sortingAlgorithms.bubbleSort;

import pl.lukaszjaskiewicz.Utils;

public class BubbleSort {

    public static void sort(int[] input){

        boolean isSorted;
        for(int i = 0; i < input.length; i++){
            isSorted = true;
            for(int j = 0; j < input.length - 1 - i; j++){
                if(input[j] > input[j + 1]){
                    Utils.swap(j, j + 1, input);
                    isSorted = false;
                }
            }
            if(isSorted){
                return;
            }
        }
    }


}
