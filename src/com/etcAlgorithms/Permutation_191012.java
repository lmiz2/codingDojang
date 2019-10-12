package com.etcAlgorithms;

import java.util.Arrays;

public class Permutation_191012 {
	int REMOVED = -9999;
	int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		int n = arr.length;
		int r = 4;		
		Permutation_191012 p = new Permutation_191012();
		p.perm(arr, 0, r, new int[r]);
		System.out.println(p.cnt);
	}
	
	private void perm(int[] nArr, int deps, int r, int[] rsArr) {
		if(deps == r) {
			System.out.println(Arrays.toString(rsArr));
			cnt++;
			return;
		}
		for(int i = 0 ; i < nArr.length ; i++) {
			if(nArr[i] == REMOVED) continue;
			int t = nArr[i];
			nArr[i] = REMOVED;
			rsArr[deps] = t;
			perm(nArr, deps+1, r, rsArr);
			nArr[i] = t;
		}
	}
	
}
