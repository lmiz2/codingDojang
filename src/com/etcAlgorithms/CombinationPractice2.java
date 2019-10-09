package com.etcAlgorithms;

import java.util.Arrays;

public class CombinationPractice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1에서 50까지의 수 중 5개를 골라 각 원소를 순열로 곱하는 모든 경우의 수의 합을 구하시오. 
		 * 
		 */
		int[] arr = new int[50];
		for(int i = 0; i < 50; i++) {
			arr[i] = i+1;
		}
//		int[] arr = new int[] {1,2,3,4};
		CombinationTool2 cp2 = new CombinationTool2(arr,5);
	}
	

}
class CombinationTool2{
	int n,r;
	int[] nArr;
	int[] rsArr;
	long sum;
	public CombinationTool2(int[] arr, int r) {
		this.n = arr.length;
		nArr = arr;
		this.r = r;
		rsArr = new int[r];
		sum = 0;
		
		comb(nArr,this.n,this.r,0,0,rsArr);
		System.out.println(sum);
	}
	
	private void comb(int[] nArr, int n, int r, int nIdx, int rsIdx, int[] rsArr) {
		if(r == 0) {
			//solute
//			System.out.println(Arrays.toString(rsArr));
			long p = 1;
			for(int i = 0 ; i < rsArr.length; i++) {
				p = p*rsArr[i]; 
			}
			sum += p;
			return;
		}else if (nIdx == n) {
			return;
		}
		rsArr[rsIdx] = nArr[nIdx];
		comb(nArr,n,r-1,nIdx+1,rsIdx+1,rsArr);
		comb(nArr,n,r,nIdx+1,rsIdx,rsArr);
		
	}
}
