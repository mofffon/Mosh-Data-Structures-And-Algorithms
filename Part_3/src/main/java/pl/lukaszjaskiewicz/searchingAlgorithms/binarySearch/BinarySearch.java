package pl.lukaszjaskiewicz.searchingAlgorithms.binarySearch;

public class BinarySearch {

    public static int searchRecursive(int target, int[] input){
        return searchRecursive(target, 0, input.length -1, input);
    }

    private static int searchRecursive(int target, int left, int right, int[] input){
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;

        if(input[mid] == target){
            return mid;
        }else if(target < input[mid]){
            return searchRecursive(target, left, mid - 1, input);
        }else{
            return searchRecursive(target, mid + 1, right, input);
        }
    }

    public static int searchIterative(int target, int[] input){

        int left = 0;
        int right = input.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(input[mid] == target){
                return mid;
            }

            if(target < input[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }
}
