package pl.lukaszjaskiewicz.searchingAlgorithms.ternarySearch;

public class TernarySearch {

    public static int search(int target, int[] input){
        return search(target, 0, input.length - 1, input);
    }

    private static int search(int target, int left, int right, int[] input){
        if(left > right){
            return -1;
        }

        int size = (right - left) / 3;
        int mid1 = left + size;
        int mid2 = right - size;

        if(target == input[mid2]){
            return mid2;
        }

        if(target == input[mid1]){
            return mid1;
        }

        if(target > mid2){
            return search(target, mid2 + 1, right, input);
        }

        if(target < input[mid1]){
            return search(target, left, mid1 - 1, input);
        }

        return search(target, mid1 + 1, mid2 - 1, input);
    }

}
