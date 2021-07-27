package com.kb.d23;

import java.util.Arrays;

public class Solution {
    private static Solution s = new Solution();
    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] ints = new int[51];
        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0]; j < ranges[i][1]; j++) {
                ints[j] += 1;
            }
        }
        for (int i = left; i <= right ; i++) {
            if(ints[i] == 0){
                return false;
            }
        }
        return true;
    }
}
