import java.util.*;

public class LeetCode {

    public static void main(String[] args) {
        int[] input = new int[]{7,1,5,3,6,4};
        System.out.println(new LeetCode().maxProfit_2(input));
    }
    // 1288
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            if (left <= intv[0] && right >= intv[1]){
                res++;
            }
            if (right >= intv[0] && right <= intv[1]){
                right = intv[1];
            }
            if (right < intv[0]){
                left = intv[0];
                right = intv[1];
            }
        }
        return intervals.length - res;
    }
    // 121
    public int maxProfit0(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i==0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length-1][0];
    }
    public int maxProfit01(int[] prices) {
        int d_0 = 0, d_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            d_0 = Math.max(d_0, d_1+prices[i]);
            d_1 = Math.max(d_1, -prices[i]);
        }
        return d_0;
    }
    // 122
    public int maxProfit_2(int[] prices) {
        int d_0 = 0, d_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = d_0;
            d_0 = Math.max(d_0, d_1+prices[i]);
            d_1 = Math.max(d_1, temp -prices[i]);
        }
        return d_0;
    }
    //188
    public int maxProfit_4(int k, int[] prices) {
        if (prices.length==0){
           return 0;
        }
        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[i] = sell[i] = Integer.MIN_VALUE/2;
        }
        for (int i = 1 ; i < n; i++) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k ; j++) {
                buy[j] = Math.max(buy[j], sell[j]-prices[i]);
                sell[j] = Math.max(sell[j], buy[j-1] + prices[i]);
            }
        }
        return Arrays.stream(sell).max().getAsInt();
    }
    // 309
    public int maxProfit_3(int[] prices) {
        int d_0 = 0, d_1 = Integer.MIN_VALUE, d_pre = 0;
        for (int price : prices) {
            int tmp = d_0;
            d_0 = Math.max(d_0, d_1 + price);
            d_1 = Math.max(d_1, d_pre - price);
            d_pre = tmp;
        }
        return d_0;
    }
    // 714
    public int maxProfit(int[] prices, int fee) {
        int d_0 = 0, d_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = d_0;
            d_0 = Math.max(d_0, d_1+prices[i]);
            d_1 = Math.max(d_1, temp -prices[i]-fee);
        }
        return d_0;
    }
    //322
    int sub(int[] coins, int amount,HashMap<Integer, Integer> map){
        if (map.containsKey(amount)){
            return map.get(amount);
        }
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i < coins.length; i++){
            int subRes = sub(coins,amount-coins[i], map);
            if (subRes == -1){
                continue;
            }
            res = Math.min(res, 1+subRes);
        }
        if (res!=Integer.MAX_VALUE){
            map.put(amount, res);
        }else {
            map.put(amount, -1);
        }
        return map.get(amount);
    }
    public int coinChange1(int[] coins, int amount) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return  sub(coins, amount, map);
    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount+1];
        visited[amount] = true;
        queue.offer(amount);

        Arrays.sort(coins);
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer head = queue.poll();
                for(int coin : coins){
                    int next = head - coin;
                    if (next == 0){
                        return  step;
                    }
                    if (next < 0){
                        break;
                    }
                    if (!visited[next]){
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
    // 877
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length-2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }
        return dp[0][length-1] >= 0;
    }
    public boolean stoneGame1(int[] piles) {
        return helper(piles, 0, piles.length-1) >= 0;
    }
    public int helper(int[] piles, int start, int end){
        if (start == end){
            return piles[start];
        }
        int left = piles[start] - helper(piles, start+1, end);
        int right = piles[end] - helper(piles, start, end-1);
        return Math.max(left, right);
    }

    // 486
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][len-1]>=0;
    }
    public int total(int[] nums, int start, int end, int turn){
        if (start==end){
            return  nums[start]*turn;
        }
        int scoreStart = nums[start]*turn + total(nums, start+1, end, -turn);
        int scoreEnd = nums[end]*turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart*turn, scoreEnd*turn)*turn;
    }
    public boolean PredictTheWinner2(int[] nums) {
        return total(nums, 0, nums.length-1, 1) >= 0;
    }



    String plusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '9'){
            ch[j] = '0';
        }else {
            ch[j] += 1;
        }
        return new String(ch);
    }
    String minusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '0'){
            ch[j] = '9';
        }else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
    // 752
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        deads.addAll(Arrays.asList(deadends));
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deads.contains(cur)){
                    continue;
                }
                if (cur.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 111
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        if (root == null){
            return 0;
        }
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()){
            int sc = q.size();
            for (int i = 0; i < sc; i++){
                TreeNode tmp = q.getFirst();
                q.removeFirst();
                if (tmp.left == null && tmp.right == null){
                    return depth;
                }
                if (tmp.left != null){
                    q.add(tmp.left);
                }
                if (tmp.right != null){
                    q.add(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int target = -1;
        for (int i = 1; i < arr.length-1; i++){
            if (arr[i] > arr[i-1]){
                target = i;
            }
        }
        return target;
    }

    // 279
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minn = Math.min(minn, dp[i-j*j]);
            }
            dp[i] = minn+1;
        }
        return dp[n];
    }
    //46
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rtl = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), rtl);
        return rtl;
    }
    public void backtrack(int[] nums, ArrayList<Integer> tmp, List<List<Integer>> rtl){
        if (tmp.size() == nums.length){
            rtl.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            backtrack(nums, tmp, rtl);
            tmp.remove(tmp.size()-1);
        }
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA!= null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!= null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;

    }

    // 1744
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        // 前缀和
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }
    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        while (n > 2){
            if (n % 2 == 1){
                return false;
            }else {
                n = n / 2;
            }
        }
        return true;
    }
    // 76
    //TODO
    public String minWindow(String s, String t) {
        int ans = -1;
        int start = 0, end = 0;
        return "";
    }
    // 904
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        int start = 0, end = 0;
        for (; end < tree.length; end++){
            map.put(tree[end], map.getOrDefault(tree[end], 0)+1);
            while (map.size() > 2){
                int cnt = map.get(tree[start]);
                if (cnt == 1){
                    map.remove(tree[start]);
                }else {
                    map.put(tree[start], cnt-1);
                }
                start++;
            }
            ans = Math.max(end-start+1, ans);
        }
        return ans;
    }

    // 209 1
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        for (int i=0; i < nums.length; i++){
            int sum = 0;
            for (int j=i; j < nums.length; j++){
                sum += nums[j];
                if (sum >= target){
                    int tmp = j-i+1;
                    if (tmp < size){
                        size = tmp;
                    }
                }
            }
        }
        return size==Integer.MAX_VALUE? 0:size;
    }
    // 209 2
    public int minSubArrayLen2(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int length;
        for (int j=0; j<nums.length; j++){
            sum += nums[j];
            while (sum >= target){
                length = j - left + 1;
                size = Math.min(size, length);
                sum -= nums[left++];
            }
        }
        return size==Integer.MAX_VALUE? 0:size;
    }


    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length;i++){
            int rtl = target - numbers[i];
            if (map.containsKey(rtl)){
                int k = i+1;
                int j = map.get(rtl)+1;
                return k>j? new int[]{j, k}:new int[]{k, j};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length) return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (i1, i2) -> i2-i1);
        ArrayList<Integer> rtl = new ArrayList<>(k);
        for (int i=0; i<k;i++){
            maxHeap.add(input[i]);
        }
        for (int i=k; i < input.length; i++){
            if (input[i] < maxHeap.peek()){
                maxHeap.remove(maxHeap.peek());
                maxHeap.add(input[i]);
            }
        }
        for (int i = k-1; i>=0 ; i--){
            rtl.add(i, maxHeap.poll());
        }
        return rtl;
    }
    public void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> clos = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        for (int i=0; i < m; i++){
            for (int j =0; j < m; j++){
                if (matrix[i][j]==0){
                    clos.add(i);
                    rows.add(j);
                }
            }
        }
        for (int i : clos){
            for (int j=0; j < n;j++){
                matrix[i][j]=0;
            }
        }
        for (int i : rows){
            for (int j=0; j < n;j++){
                matrix[j][i] = 0;
            }
        }
    }
    public List<List<Integer>> threeSum(int [] nums){
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            while (left < right){
                if (nums[i] + nums[left]+nums[right] < 0){
                    left++;
                }else if (nums[i] + nums[left]+nums[right] > 0){
                    right--;
                }else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[left]);
                    integers.add(nums[i]);
                    integers.add(nums[right]);
                    result.add(integers);
                    right--;
                    left++;
                    while (left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while (left < right&& nums[right+1]==nums[right]){
                        right--;
                    }
                }
            }

        }
        return result;
    }

    // 50
    public double myPow(double x, int n){
        long N = n;
        return N>= 0? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    public double quickMul(double x, long N){
        if (N == 0){
            return 1.0;
        }
        double y = quickMul(x, N/2);
        return N % 2 == 0? y*y:y*y*x;
    }

    // 830
    public List<List<Integer>> largeGroupPositions(String s){
        s = s + "A";
        List<List<Integer>> result = new ArrayList<>();
        int begin = 0;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(i-1)){
                if (i - begin >= 3){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(begin);
                    temp.add(i-1);
                    result.add(temp);
                }
                begin = i;
            }
        }
        return result;
    }
    
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode partition(ListNode head, int x){
        if (head == null) return null;
        ListNode dy1 = new ListNode(0);
        ListNode dy2 = new ListNode(0);
        ListNode node1 = dy1;
        ListNode node2 = dy2;

        while (head != null){
            if (head.val < x){
                node1.next = head;
                node1 = node1.next;
            }else {
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;

        }
        node1.next = dy2.next;
        node2.next = null;
        return dy1.next;
    }
    public int[] maxSlidingWindow(int[] nums, int k){
        if (nums == null || nums.length < 2) return nums;
        LinkedList<Integer> integers = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for (int i=0; i < nums.length; i++){
            while (!integers.isEmpty()&&nums[integers.peekLast()] <= nums[i]){
                integers.pollLast();
            }
            integers.addLast(i);
            if (integers.peek() <= i-k){
                integers.poll();
            }
            if (i-k+1>=0){
                result[i-k+1] = nums[integers.peek()];
            }
        }
        return result;
    }


    // 1700
    public int countStudents(int[] students, int[] sandwiches){
        int n = students.length;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int student:students){
            queue.offer(student);
        }
        int j = 0;
        int count = 0;
        int curSize = -1;
        while (queue.size() != curSize){
            curSize = queue.size();
            for (int i=0; i < curSize; i++){
                int value = queue.remove();
                if (value == sandwiches[j]){
                    j++;
                    count++;
                }else {
                    queue.offer(value);
                }
            }
        }
        return n-count;
    }

    // 188
    public int maxProfit(int k, int[] prices){
        if (prices.length == 0) return 0;
        if (k >= prices.length/2) return maxProfit(prices);
        int[][] dp = new int[k+1][2];
        for (int i =1; i <= k; i++){
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i=1; i <prices.length; i++){
            for (int j=k; j > 0; j--){
                dp[j][0] = Math.max(dp[j][0], dp[j][1]+prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0]-prices[i]);
            }
        }
        return dp[k][0];
    }

    private int maxProfit(int[] prices) {
        int profit0=0, profit1 = -prices[0];
        for (int i=1; i<prices.length; i++){
            profit0 = Math.max(profit0, profit1+prices[i]);
            profit1 = Math.max(profit1, profit0-prices[i]);
        }
        return profit0;
    }
}
