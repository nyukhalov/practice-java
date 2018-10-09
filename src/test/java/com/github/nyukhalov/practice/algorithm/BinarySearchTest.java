package com.github.nyukhalov.practice.algorithm;

import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest extends TestSuite {
    @Test
    public void WhenInputIsEmpty_ThenReturnFalse() {
        boolean found = BinarySearch.search(null, 1);

        Assert.assertFalse(found);
    }

    @Test
    public void WhenInputEmpty_ThenReturnFalse() {
        boolean found = BinarySearch.search(new Integer[]{}, 1);

        Assert.assertFalse(found);
    }

    @Test
    public void WhenInputHasSingleItemAndIterIsTarget_ThenReturnTrue() {
        Integer[] data = new Integer[]{1};
        boolean found = BinarySearch.search(data, data[0]);

        Assert.assertTrue(found);
    }

    @Test
    public void WhenInputHasTwoItemsAndTargetIsRight_ThenReturnTrue() {
        Integer[] data = new Integer[]{1,2};
        boolean found = BinarySearch.search(data, data[1]);

        Assert.assertTrue(found);
    }

    @Test
    public void WhenInputHasTwoItemsAndTargetIsLeft_ThenReturnTrue() {
        Integer[] data = new Integer[]{1,2};
        boolean found = BinarySearch.search(data, data[0]);

        Assert.assertTrue(found);
    }

    @Test
    public void WhenInputHasThreeItemsIncludingTarget_ThenReturnTrue() {
        Integer[] data = new Integer[]{1,3,2};
        boolean found = BinarySearch.search(data, data[2]);

        Assert.assertTrue(found);
    }
}
