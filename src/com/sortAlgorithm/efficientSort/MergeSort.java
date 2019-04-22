package com.sortAlgorithm.efficientSort;

public class MergeSort {
	int[] unsortedArr = {6,5,3,1,8,7,2,4,3};
	int[] sortedArr ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms = new MergeSort();
		ms.sortedArr = new int[ms.unsortedArr.length];
		ms.merging(ms.unsortedArr,0,ms.unsortedArr.length-1);
		for(int i : ms.sortedArr)
			System.out.println(i+" ");
	}
	
	public void merging(int[] arr, int left, int right) {
		int middle ;
		
		if(left<right) {
			middle = left+right/2;
			merging(arr, left, middle);
			merging(arr, middle+1, right);
			sorting(arr, left, middle, right);
		}
	}
	
	public void sorting(int[] arr, int left, int middle, int right) {
		int i, j, k, w;
		i = left;
		j = middle+1;
		k = left;
		
		while(i<=middle && j<= right) {
			if(arr[i] <= arr[j]) {
				sortedArr[k++] = arr[i++];
			}else {
				sortedArr[k++] = arr[j++];
			}
		}
	}

}


