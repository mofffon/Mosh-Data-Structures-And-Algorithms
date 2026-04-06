package pl.lukaszjaskiewicz.searchingAlgorithms.linearSearch;

public class LinearSearch {

    public static int search(int target, int[] input){

        for( int i = 0; i < input.length; i++){
            if(input[i] == target){
                return i;
            }
        }

        return -1;
    }

}
