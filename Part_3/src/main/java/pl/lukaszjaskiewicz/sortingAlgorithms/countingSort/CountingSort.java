package pl.lukaszjaskiewicz.sortingAlgorithms.countingSort;

import static pl.lukaszjaskiewicz.Utils.getMax;

public class CountingSort {

    public static void sort(int[] input){
         int max = getMax(input);

         int[] counters = new int[max + 1];

         for(int i = 0; i < input.length; i++){
             counters[input[i]]++;
         }

         int pointer = 0;
         for(int i = 0; i < counters.length; i++){
             for(int j = 0; j < counters[i]; j++)
                 input[pointer++] = i;
         }
    }
}
