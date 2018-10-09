package com.github.nyukhalov.practice.algorithm;

import java.util.Arrays;

public class BinarySearch {

    /**
     * Finds whether the target is in the data or not.
     * There are five corner cases:
     * - data is null
     * - data is empty
     * - data length is 1
     * - data length is even
     * - data length is odd
     *
     * Complexity analysis:
     * - Time complexity (worst) = O(log(n))
     * - Time complexity (average) = O(log(n))
     * - Space complexity = O(1)
     */
    public static <T extends Comparable<T>> boolean search(T[] data, T target) {
        if (data == null) return false;
        Arrays.sort(data);
        int lo = 0;
        int hi = data.length - 1;
        boolean found = false;

        while(!found && lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            T midEl = data[mid];
            if (midEl.equals(target)) {
                found = true;
            } else if (midEl.compareTo(target) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return found;
    }
}
