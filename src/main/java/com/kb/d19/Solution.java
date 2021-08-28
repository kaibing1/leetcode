package com.kb.d19;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public int maxFrequency(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l=0,res=1;
        for (int r = 1; r < n; r++) {
            total += (long) (nums[r]-nums[r-1])*(r-l);
            while (total>k){
                total -= nums[r]-nums[l];
                ++l;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        for (int i = 0; i < len; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(maxF[i-1]*nums[i], Math.max(minF[i-1]*nums[i], nums[i]));
            minF[i] = Math.min(minF[i-1]*nums[i], Math.min(maxF[i-1]*nums[i], nums[i]));
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    public int maximalSquare(char[][] matrix){
        int maxSide = 0;
        if (matrix==null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1'){
                    if (i==0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
    public int countSquares(int[][] matrix) {
        int ans = 0;
        if (matrix==null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1'){
                    if (i==0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    }
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> q = new LinkedList<>();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (rains[i] == 0){
                q.offer(i);
                ans[i] = 1;
            }else {
                ans[i] = -1;
                if (!map.containsKey(rains[i])){
                    map.put(rains[i], i);
                }else {
                    if (q.isEmpty() || q.getLast() < map.get(rains[i])){
                        return new int[]{};
                    }
                    int idx = -1;
                    for (int j = 0; j < q.size(); j++) {
                        if (q.get(j) > map.get(rains[i])){
                            idx = q.get(j);
                            q.remove(j);
                            break;
                        }
                    }
                    map.put(rains[i], i);
                    ans[idx] = rains[i];
                }
            }
        }
        return ans;
    }

    public boolean isPrefixString(String s, String[] words) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String word : words) {
            stringBuffer.append(word);
            String s1 = stringBuffer.toString();
            if (s.equals(s1)){
                return true;
            }
        }
        return false;
    }
    @Test
    public void oopsTest(){
        Solution solution = new Solution();
        int n = 5;
        int[][] mines = new int[1][2];
        mines[0][0] = 4;
        mines[0][1] = 2;
        System.out.println(solution.orderOfLargestPlusSign(n, mines));
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] d = new int[n][n];
        for (int[] mine : mines) {
            int x = mine[0];
            int y = mine[1];
            d[x][y] = 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tx = i;
                int ty = j;
                int tmp = 0;
                while (tx >= 0 && d[tx][j] == 0){
                    tx--;
                }
                tmp = i - tx;
                tx = i;
                while (tx < n && d[tx][j] == 0){
                    tx++;
                }
                tmp = Math.min(tmp, tx-i);
                while (ty >= 0 && d[i][ty] == 0){
                    ty--;
                }

                tmp = Math.min(tmp, j-ty);
                ty = j;
                while (ty < n && d[i][ty]==0){
                    ty++;
                }
                tmp = Math.min(tmp, ty-j);
                ans  = Math.max(ans, tmp);
            }
        }
        return ans;
    }
    @Test
    public void swTest(){
        int[] bucket = {1, 2};
        int[] vat = {6, 8};
        int i = new Solution().storeWater(bucket, vat);
        System.out.println(i);
    }
    public int storeWater(int[] bucket, int[] vat) {
        int max = 0;
        for (int v : vat) {
            if (max < v){
                max = v;
            }
        }
        if (max == 0) return 0;
        int len = bucket.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 1000; i++) {
            int per = 0;
            int cur = i;
            for (int j = 0; j < len; j++) {
                per = (vat[j] + i -1) / i;
                cur += Math.max(0, per-bucket[j]);
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
    @Test
    public void dcuTest(){
        System.out.println(new Solution().detectCapitalUse("FlaG"));
    }
    public boolean detectCapitalUse(String word) {
        char[] array = word.toCharArray();
        boolean firstFlag = false;
        int Ucont=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>='A' && array[i]<='Z'){
                if (i==0){
                    firstFlag = true;
                }
                Ucont++;
            }
        }
        if (Ucont == array.length){
            return true;
        }else if (firstFlag && Ucont==1){
            return true;
        }else if (Ucont==0){
            return true;
        }
        return false;
    }
    @Test
    public void cpotTest(){
        Solution solution = new Solution();
        System.out.println(solution.checkPowersOfThree2(21));
    }
    public boolean checkPowersOfThree(int n) {

        int x = 1;
        HashSet<Integer> set = new HashSet<>();
        while (n >= 3){
            x = 1;
            int i = 0;
            while (x <= n){
                x *= 3;
                i++;
            }
            x /= 3;
            i--;
            if (set.contains(i)){
                return false;
            }
            set.add(i);
            n -= x;
        }
        if (n == 0 || n == 1){
            return true;
        }

        return false;
    }
    public boolean checkPowersOfThree2(int n) {
        while (n > 0){
            if (n % 3 == 2){
                return false;
            }
            n /= 3;
        }
        return true;
    }
    @Test
    public void adTest(){
        System.out.println(new Solution().addDigits(38));
    }
    public int addDigits(int num) {
        while (num >= 10){
            int tmp = num;
            int ans = 0;
            while (tmp >= 10){
                ans += tmp%10;
                tmp /= 10;
            }
            ans+= tmp;
            num = ans;
        }
        return num;
    }
    int rtl = 0;
    public int combinationSum4(int[] nums, int target) {
        solve(nums, target, 0);
        return rtl;
    }
    public void solve(int[] nums, int target, int sum){
        if (sum==target){
            rtl++;
            return;
        }
        if (sum > target){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            solve(nums, target, sum);
            sum -= nums[i];
        }
    }

    public int combinationSum42(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (num <= i){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
