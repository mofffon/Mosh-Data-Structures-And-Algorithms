package pl.lukaszjaskiewicz.searchingAlgorithms.jumpSearch;

public class JumpSearch {

    public static int search(int target, int[] input){

        int size = input.length / (int)(Math.sqrt(input.length));

        int start = 0;
        int next = size - 1;

        while(start < input.length){
            if(next >= input.length){
                next = input.length - 1;
            }

            if(input[start] <= target && input[next] >= target) {
                for (int i = start; i <= next; i++) {
                    if (input[i] == target) {
                        return i;
                    }
                }

                return -1;
            }

            start += size;
            next += size;
        }

        return -1;
    }
}
