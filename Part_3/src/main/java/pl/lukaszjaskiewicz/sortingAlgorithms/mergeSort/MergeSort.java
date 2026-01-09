package pl.lukaszjaskiewicz.sortingAlgorithms.mergeSort;

public class MergeSort {

    public static void sort(int[] arr){
        if(arr.length < 2){
            return;
        }

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr,0, left,0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        sort(left);
        sort(right);

        int leftPointer = 0;
        int rightPointer = 0;

        int i = 0;
        while(leftPointer < left.length && rightPointer < right.length){
            if(left[leftPointer] <= right[rightPointer]){
                arr[i++] = left[leftPointer++];
            }else{
                arr[i++] = right[rightPointer++];
            }
        }

        for(int j = leftPointer; j < left.length; j++){
            arr[i++] = left[j];
        }

        for(int j = rightPointer; j < right.length; j++){
            arr[i++] = right[j];
        }
    }
}
