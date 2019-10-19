package com.etcAlgorithms;

import java.util.Arrays;

public class Combination_191012 {
	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		int r = 9;
		Combination_191012 c = new Combination_191012();
		c.comb(arr, arr.length, r, 0, 0, new int[r]);
		System.out.println(cnt);
	}
	public void comb(int[] nArr, int n, int r, int nIdx, int rsIdx, int[] rsArr) {
		if(r == 0) {
			cnt++;
			System.out.println(Arrays.toString(rsArr));
			return ;
		}else if (nIdx == n) return;
		
		
		rsArr[rsIdx] = nArr[nIdx];
		comb(nArr,n,r-1,nIdx+1,rsIdx+1,rsArr);
		comb(nArr,n,r,nIdx+1,rsIdx,rsArr);
	}
}