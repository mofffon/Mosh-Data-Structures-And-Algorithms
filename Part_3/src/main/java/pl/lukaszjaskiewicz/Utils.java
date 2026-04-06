package pl.lukaszjaskiewicz;

public class Utils {

    public static void swap(int index1, int index2, int[] arr){
        var temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int getMax(int[] input){
        int max = input[0];

        for(int i = 1; i < input.length; i++){
            if(input[i] > max){
                max = input[i];
            }
        }

        return max;
    }

}
