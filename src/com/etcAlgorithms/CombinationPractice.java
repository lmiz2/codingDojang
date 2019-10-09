package com.etcAlgorithms;

import java.util.Arrays;

public class CombinationPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationTool ct = new CombinationTool(new int[] {1, 2, 3, 4}, 2);
//		CombinationTool ct = new CombinationTool(new int[] {1, 2, 3, 4}, 3);
	} 

}
class CombinationTool{
	/*
	 * 조합은 보통 다음과 같이 나타낸다.
	 * nCr 
	 * n은 뽑을 후보들의 총 갯수, r은 n 중에서 뽑을 결과의 갯수이며,
	 * C는 Combination의 약자이다.
	 * 
	 * 4C2의 모든 경우의 수를 출력하는 프로그램을 작성해보자.
	 * 
	 */
	int r;
	int[] nArr;
	int[] rsArr;
	public CombinationTool(int[] arr, int r) {
		nArr = arr;
		rsArr = new int[r];
		this.r = r;
		comb(nArr,this.nArr.length, this.r, 0, 0, this.rsArr);
	}
	
	private void comb(int[] arr, int n, int r, int nIdx, int rsIdx, int[] rsArr) {
		if(r == 0) { // r개를 선택함.
			System.out.println(Arrays.toString(rsArr));
			return;
		}else if (nIdx == n) {
			return;
		}
		comb(arr,n,r,nIdx+1,rsIdx,rsArr);

		rsArr[rsIdx] = arr[nIdx];
		comb(arr,n,r-1,nIdx+1,rsIdx+1,rsArr);
	}
}