package dsapractice.questions.array;

import java.util.HashMap;

/*
* Given an integer array nums and an integer k, return the total number of continuous sub arrays whose sum equals to k.
*
* This is strictly for Positive values
*
* */
public class Question1 {

    public static void main(String[] args) {

       int[]  nums = {1,2,3,-3,1,1,1,4,2,-3};
       int target = 3;
       int result = subArrayUsingHashMap(nums, target);
        System.out.println(result);
    }

    public static int subArraysCount(int [] arr, int target){
        int count = 0;
       // int start = 0, end = arr.length -1;

        for(int i = 0; i< arr.length; i++){
            int currSum = 0;
            for(int j = i ; j< arr.length ; j++){
                currSum +=  arr[j];
                if(currSum == target){
                    count++;
                } //else if(currSum > target ) break; //This condition exists in the condition when we have only positive values.
            }
        }

        return count;
    }

    public static int subArrayUsingHashMap(int [] arr, int target){
        int count = 0, sum =0;

        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);

        for(int num : arr){
            sum += num;

            if(prefixSum.containsKey(sum - target)){
                count += prefixSum.get(sum - target);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
