
package com.SWExpertAcademy;

import java.util.Scanner;

public class Q7508 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{		
			Solutioning s = new Solutioning(sc);
			System.out.println("#"+test_case+" "+s.ans);
		}
	}	


}
class Solutioning{
	int machineCnt , loadCnt;
	int[] machines, loads;
	int maxMachinePower;
	int maxLoadWeight;
	int ans;
	public Solutioning(Scanner sc) {
		// TODO Auto-generated constructor stub
		machineCnt = sc.nextInt();
		maxLoadWeight = 0;
		maxMachinePower = 0;
		machines = new int[machineCnt];
		for(int i = 0 ; i < machineCnt ; i++) {
			machines[i] = sc.nextInt();
			if(machines[i] > maxMachinePower) maxMachinePower = machines[i];
		}
		loadCnt = sc.nextInt();
		loads = new int[loadCnt];
		for(int i = 0 ; i < loadCnt ; i++) {
			loads[i] = sc.nextInt();
			if(loads[i] > maxLoadWeight) maxLoadWeight = loads[i];
		}
		// init end
		ans = getAnswer();
	}
	
	public int getAnswer() {
		if(maxLoadWeight > maxMachinePower) {
			return -1;
		}
		mergeSort(machines,0,machineCnt-1, new int[machineCnt]);
		mergeSort(loads,0,loadCnt-1, new int[loadCnt]);
		
		int time = 0;
		boolean finished = false;
		while(!finished) { // 거중기들이 1분마다 한루프
			int loadIdx = loads.length-1;
			
			for(int i = machineCnt-1; i >= 0 && loadIdx >= 0; i --) {
				while(loads[loadIdx]<= 0 || loads[loadIdx] > machines[i]) loadIdx--;
				loads[loadIdx--] = 0;
				if(loadIdx == -1) {
					finished = true;
					break;
				}
			}
			time++;
		}
//		for(int a : loads) {
//			if(a != 0) {
//				time = -1;
//				break;
//			}
//		}
		return time;
		
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