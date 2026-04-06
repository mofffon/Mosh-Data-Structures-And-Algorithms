package pl.lukaszjaskiewicz.sortingAlgorithms.bucketSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    public static void sort(int[] input, int numberOfBuckets){
        LinkedList<Integer>[] buckets = new LinkedList[numberOfBuckets];

        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }

        for( int item: input){
            int index = item / numberOfBuckets;
            buckets[index].add(item);
        }

        int index = 0;
        for(var bucket: buckets){
            Collections.sort(bucket);
            for(var item: bucket){
                input[index++] = item;
            }
        }
    }
}
