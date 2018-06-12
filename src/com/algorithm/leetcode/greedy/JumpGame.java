package com.algorithm.leetcode.greedy;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int leftMostGoodPosition = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= leftMostGoodPosition) {
				leftMostGoodPosition = i;
			}
		}

		return leftMostGoodPosition == 0;
	}

	public static void main(String[] args) {
		JumpGame jp = new JumpGame();
		System.out.println(jp.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jp.canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(jp.canJump(new int[] { 2, 0, 0 }));
		System.out.println(jp.canJump(new int[] { 1, 1, 1, 1, 0, 0 }));
		System.out.println(jp.canJump(new int[] { 4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0 }));

	}

}
