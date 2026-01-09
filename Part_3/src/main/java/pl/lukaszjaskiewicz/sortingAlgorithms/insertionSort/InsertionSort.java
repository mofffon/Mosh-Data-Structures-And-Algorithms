package pl.lukaszjaskiewicz.sortingAlgorithms.insertionSort;

import pl.lukaszjaskiewicz.Utils;

public class InsertionSort {

    public static void sort(int[] input){

        for(int i = 0; i < input.length; i++){

            int current = input[i];

            for(int j = i - 1; j >= 0; j--){

                if(input[j] > current){
                    input[j+ 1] = input[j];
                    input[j] = current;
                }else{
                    break;
                }
            }
        }
    }

}
