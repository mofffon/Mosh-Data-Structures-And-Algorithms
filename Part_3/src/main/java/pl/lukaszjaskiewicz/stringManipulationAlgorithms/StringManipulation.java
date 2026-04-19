package pl.lukaszjaskiewicz.stringManipulationAlgorithms;

import java.util.*;
import pl.lukaszjaskiewicz.Utils;

public class StringManipulation {

    final static private List<Character> vowels = Arrays.asList(new Character[]{'A', 'E', 'I', 'O', 'U'});

    public static int countVowels(String input){
        if(input == null){
            return 0;
        }

        int count = 0;

        for(var ch: input.toUpperCase().toCharArray()){
            if(vowels.contains(ch)){
                count++;
            }
        }

        return count;
    }

    public static String reverse(String input){
        if(input == null || input.isEmpty()){
             return "";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = input.length() - 1; i >= 0; i--){
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }

    public static String reverseWords(String input){
        if(input == null || input.isEmpty()){
            return "";
        }

        input = input.trim();

        if(!input.contains(" ")){
            return input;
        }

        String[] splitInput = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = splitInput.length - 1; i >= 0; i--){
            String candidate = splitInput[i];
            if(!candidate.isEmpty()){
                if(!sb.isEmpty()){
                    sb.append(" ");
                }

                sb.append(candidate);
            }
        }

        return sb.toString();
    }

    public static boolean isRotation(String candidate, String target){

        if (candidate == null || target == null || candidate.length() != target.length()){
            return false;
        }

        if(candidate.equals(target)){
            return true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < target.length(); i++){
            candidate = candidate.substring(1) + candidate.charAt(0);

            if(target.equals(candidate)){
                return true;
            }
        }

        return false;
    }

    public static String removeDuplicates(String input){

        if(input == null || input.isEmpty()){
            return "";
        }

        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(Character ch: input.toCharArray()){
            if (!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static char getMax(String input){
        if (input == null || input.isEmpty()){
            throw new IllegalArgumentException("Can not work with this input.");
        }

        Map<Character, Integer> counters = new HashMap<>();
        for (var item: input.toCharArray()){
            if (!counters.containsKey(item)){
                counters.put(item, 1);
            }else{
                counters.replace(item, counters.get(item) + 1);
            }
        }

        var maxChar = input.charAt(0);
        var maxCount = counters.get(input.charAt(0));

        for (var ch: counters.keySet()){
            if(counters.get(ch) > maxCount){
                maxChar = ch;
                maxCount = counters.get(ch);
            }
        }

        return maxChar;
    }

    public static String capitalize(String sentence){
        if (sentence == null || sentence.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        var splitSentence = sentence.trim().split(" ");

        for (String s : splitSentence) {

            if (s.isEmpty())
                continue;

            char[] splitWord = s.toCharArray();


            if (splitWord[0] >= 97 && splitWord[0] <= 122) {
                splitWord[0] = (char) (splitWord[0] - 32);
            }

            for (int j = 1; j < splitWord.length; j++){
                if (splitWord[j] >= 65 && splitWord[j] <= 90){
                    splitWord[j] = (char)(splitWord[j] + 32);
                }
            }

            sb.append(splitWord);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static boolean isAnagram(String candidate, String target){
        if (candidate == null || target == null || candidate.isEmpty() || target.isEmpty() || candidate.length() != target.length()){
            return false;
        }

        Set<Character> targetSet = new HashSet<>();

        var splitTarget = target.toCharArray();
        var splitCandidate = candidate.toCharArray();

        for (char ch : splitTarget) {
            targetSet.add(ch);
        }

        for (var ch: splitCandidate){
            if (!targetSet.contains(ch)){
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String input){
        if (input == null || input.isEmpty()){
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left <= right){
            if (input.charAt(left++) != input.charAt(right--)){
                return false;
            }
        }

        return true;
    }
}
