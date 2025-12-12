package pl.lukaszJaskiewicz.hashMapHashSet;

import java.util.*;

public class HashMapHashSetExercises {

    public static Character findFirstNonRepeating(String input){

        if(input == null){
            throw new IllegalArgumentException("The argument must be a string. Is null.");
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();

        for(var letter : chars) {
            int count = map.containsKey(letter)? map.get(letter) + 1: 1;
            map.put(letter, count);
        }

        for(char letter: chars){
            if(map.get(letter) == 1){
                return letter;
            }
        }

        return null;
    }

    public static Character findFirstRepeating(String input) {
        if(input == null){
            throw new IllegalArgumentException("Input mus be a string. Is null.");
        }

        Set<Character> set = new HashSet<>();
        char[] chars = input.toCharArray();

        for (char ch: chars){
            if(set.contains(ch)){
                return ch;
            }
            set.add(ch);
        }

        return null;
    }

    public static int findMostRepeated(int[] input){
        if(input ==  null || input.length == 0){
            throw new IllegalArgumentException("Input can not be null or zero length.");
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int num: input){
            if(!hashMap.containsKey(num)){
                hashMap.put(num, 1);
            }else{
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

        return getMaxValueKey(hashMap);
    }

    private static int getMaxValueKey(HashMap<Integer, Integer> hashMap) {
        int max = Integer.MIN_VALUE;
        Integer key = null;

        for(var entry: hashMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        return key;
    }

    public static int countPairsOfDiff(int k, int[] input){
        if(input == null){
            throw new IllegalArgumentException("The input arr can not be null.");
        }

        Set<Integer> set = new HashSet<>();

        for(int num: input){
            set.add(num);
        }

        int count = 0;
        for(int num: input){
            if(set.contains(num + k)){
                count++;
            }
            if(set.contains(num - k)){
                count++;
            }
            set.remove(num);
        }

        return count;
    }

    public static int[] findTwoSum(int target, int[] input){
        if(input == null){
            throw new IllegalArgumentException("The input arr can not be null.");
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            hashMap.put(input[i], i);
        }

        for(int i = 0; i < input.length; i++){
            Integer index2 = hashMap.get(target - input[i]);

            if(index2 != null){
                return new int[]{i, index2};
            }
        }

        return null;
    }
}
