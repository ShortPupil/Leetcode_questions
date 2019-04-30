class Solution {
    public int findPairs(int[] nums, int k) {
        // k小于0无意义
		if (nums == null || nums.length == 0 || k < 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		for (int num : nums)
			map.put(num, i++);
		int res = 0;
		for (i = 0; i < nums.length; i++)
			// map.get(nums[i] + k) != i避免nums[i] + k也在nums.length之内的情况,
			if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {
				map.remove(nums[i] + k);
				res++;
			}
		return res;
    }
}