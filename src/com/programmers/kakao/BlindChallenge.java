package com.programmers.kakao;

public class BlindChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		int[] a = {4,1,3,3};
		System.out.println(s.solution(a));

	}

}
class Solution2 {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int[] arrs = arr;
        System.out.println(arrs.toString());
        quickSort(arrs, 0, arrs.length - 1);
        for(int i = 1; i <= arrs.length; i++){
        	System.out.println(arrs[i]);
            if(i != arrs[i-1]){
                answer =  false;
            }
        }
        
        return answer;
    }
    
    public static int partition(int arr[], int left, int right) {

        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while ((arr[left] < pivot) && (left < right))
                left++;
            while ((arr[right] > pivot) && (left < right))
                right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        return left;
    }

    public static void quickSort(int arr[], int left, int right) {

        if (left < right) {
            int pivotNewIndex = partition(arr, left, right);

            quickSort(arr, left, pivotNewIndex - 1);
            quickSort(arr, pivotNewIndex + 1, right);
        }

    }


//ÃâÃ³: http://creatordev.tistory.com/70 [Creator Developer]
}