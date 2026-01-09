package pl.lukaszjaskiewicz;

public class Utils {

    public static void swap(int index1, int index2, int[] arr){
        var temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }



}
