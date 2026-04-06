package pl.lukaszjaskiewicz.searchingAlgorithms.exponentialSearch;

import pl.lukaszjaskiewicz.searchingAlgorithms.binarySearch.BinarySearch;

public class ExponentialSearch {

    public static int search(int target, int[] input){

        if(target < input[0] || target > input[input.length -1]){
            return -1;
        }

        int bound = 2 > input.length? 2: input.length - 1;
        int prevBound =0;

        while(input[bound] <= target){
            prevBound = bound;

            bound = bound * 2;
            if(bound >= input.length){
                bound = input.length -1;
                break;
            }
        }

        for(int i = prevBound; i <= bound; i++){
            if(input[i] == target){
                return i;
            }
        }

        return -1;
    }
}
