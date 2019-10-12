package com.etcAlgorithms;

import java.util.Arrays;

public class Combination_191012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		int r = 3;
		Combination_191012 c = new Combination_191012();
		c.comb(arr, arr.length, r, 0, 0, new int[r]);
	}
	public void comb(int[] nArr, int n, int r, int nIdx, int rsIdx, int[] rsArr) {
		if(r == 0) {
			System.out.println(Arrays.toString(rsArr));
			return ;
		}else if (nIdx == n) return;
		
		
		rsArr[rsIdx] = nArr[nIdx];
		comb(nArr,n,r-1,nIdx+1,rsIdx+1,rsArr);
		comb(nArr,n,r,nIdx+1,rsIdx,rsArr);
	}
}