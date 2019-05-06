package com.sortAlgorithm.efficientSort;

public class MergeSort {
	int[] unsortedArr = {6,5,3,1,8,7,2,4,3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms = new MergeSort();		
		ms.mergeSort(ms.unsortedArr,0,ms.unsortedArr.length-1, new int[ms.unsortedArr.length]);
		for(int i : ms.unsortedArr)
			System.out.print(i+" ");
	}
	
	public static void mergeSort(int[] data, int left, int right, int[] outputArr) {
		int mid;
		if(left < right) {
			mid = (left+right)/2;
			mergeSort(data, left, mid, outputArr);
			mergeSort(data, mid+1, right, outputArr);
			merging(data,left,mid,right, outputArr);
		}
	}
	public static void merging(int[] data, int left, int mid, int right, int[] outputArr) {
		int i, j, k, t;
		i = left;
		j = mid+1;
		k = left;
		
		while(i <= mid && j<= right) {
			if(data[i] <= data[j])
				outputArr[k] = data[i++];
			else
				outputArr[k] = data[j++];
			k++;
		}
		
		if(i > mid) {
			for( t = j; t <= right; t++, k++) {
				outputArr[k] = data[t];
			}
		}else {
			for( t = i ; t <= mid ; t++, k++) {
				outputArr[k] = data[t];
			}
		}
		for(t = left ; t <= right; t++) {
			data[t] = outputArr[t];
		}		

	}

}


