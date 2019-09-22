package com.etcAlgorithms;

import java.util.Arrays;

public class PermuPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,5,6,7,8,9};
		PermutationTool pt = new PermutationTool(arr, 8);
	}

	static void getCal(int[] arr) {
		int tmp = 0;
		for(int i = 0+1 ; i < arr.length ; i++) {
			tmp += arr[i-1] * arr[i];
		}
		System.out.println(tmp);
	}
}
class PermutationTool{
	int cnt = 0;
	final int REMOVED = -1;
	int resultNumberCnt = 0;
	int[] arr;
	int[] resultArr;
	
	PermutationTool(int[] arr, int resultNumberCnt){
		this.arr = arr;
		this.resultArr = new int[resultNumberCnt];
		this.resultNumberCnt = resultNumberCnt;
		recursive(arr, 0);
		System.out.println("Total COUNT : "+cnt);
	}
	
	void recursive(int[] arr, int deps){
		if(deps == resultNumberCnt) {
			System.out.println(Arrays.toString(resultArr));
			PermuPractice.getCal(resultArr);
			cnt++;
			return;
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] != REMOVED) { //중복 미허용시 주석 삭제
				resultArr[deps] = arr[i];
				arr[i] = REMOVED; //중복 미허용시 주석 삭제
				recursive(arr, deps+1);
				arr[i] = resultArr[deps];//중복 미허용시 주석 삭제
			} //중복 미허용시 주석 삭제
		}
	}	
}

