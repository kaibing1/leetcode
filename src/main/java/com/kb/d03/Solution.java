package com.kb.d03;

import org.junit.Test;

public class Solution {
    @Test
    public void testSortColors(){
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0, 0};
        solution.sortColors(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }

    public void sortColors(int[] nums) {
        if (nums.length == 1){
            return;
        }
        int p = 0;
        int q = nums.length-1;
        int i = 0;
        while (i <= q){
            if (nums[i] == 0){
                swap(nums, i, p);
                p++;
                if (nums[i] == 0){
                    i++;
                }
            }else if (nums[i] == 1){
                i++;
            }else if (nums[i] == 2){
                swap(nums, i, q);
                q--;
            }
        }
    }
    public void swap(int[] nums, int s, int t){
        int tmp = nums[s];
        nums[s] = nums[t];
        nums[t] = tmp;
    }

    public boolean exist(char[][] board, String word) {

        int w = board.length;
        int h = board[0].length;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(search(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, int i, int j, int index, String word){
        if (index >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        board[i][j] += 256;
        boolean result = search(board, i-1, j, index+1, word) ||search(board, i+1, j, index+1, word)||
                search(board, i, j-1, index+1, word) || search(board, i, j+1, index+1, word);
        board[i][j] -= 256;
        return result;
    }

    @Test
    public void testBoard(){
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},{'A','D', 'E', 'E'}};
        String word = "ABCCED";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
}
