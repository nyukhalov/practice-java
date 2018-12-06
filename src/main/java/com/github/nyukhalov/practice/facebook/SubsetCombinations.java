package com.github.nyukhalov.practice.facebook;

import java.util.*;

// Given an array of numbers and a number k
// find all unique subsets of the array of length k.
public class SubsetCombinations {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int k = 3;
        List<List<Integer>> sets = new SubsetCombinations().uniqSets(nums, k);
        for (List<Integer> set: sets) {
            for(Integer i: set) {
                System.out.print(i);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> uniqSets(int[] nums, int k) {
        return uniqSets(nums, k, 0);
    }

    private List<List<Integer>> uniqSets(int[] nums, int k, int offsetBase) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < k) return result;
        if (nums.length - offsetBase == k) {
            List<Integer> set = new ArrayList<>();
            result.add(set);
            for (int i=offsetBase; i<nums.length; i++) {
                set.add(nums[i]);
            }
            return result;
        }
        if (k == 1) {
            for (int i=offsetBase; i<nums.length; i++) {
                List<Integer> set = new ArrayList<>();
                result.add(set);
                set.add(nums[i]);
            }
            return result;
        }

        List<List<Integer>> sets = uniqSets(nums, k - 1, offsetBase + 1);
        for (List<Integer> set: sets) {
            set.add(nums[offsetBase]);
            result.add(set);
        }
        sets = uniqSets(nums, k, offsetBase + 1);
        result.addAll(sets);

        return result;
    }
}
