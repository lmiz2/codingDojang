package com.SWExpertAcademy;

public class Comb {

	int[] T; //nPr을 이루는 각각의 경우를 저장
	int[] data;;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comb b = new Comb();
		b.T = new int[10];
		b.data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		b.Comb(10, 8, 10);

	}
	void process(int q){
	    for(int i = q-1; i>= 0; i--){
	            System.out.printf("%d ", T[i]);
	    }
	    System.out.printf("\n");
	}
	/*data[]에서 앞에서부터 n개의 숫자 중 r개를 선택해서 조합을 출력하는 함수. q는 출력 시 출력 갯수 지정*/
	void Comb(int n, int r, int q){
	    if(r == 0){
	        process(q);
	        return;
	    }else if(n<r){
	        return;
	    }
	    else {  //loop이 아님
	        T[r-1] = data[n-1];
	        Comb(n-1, r-1, q);  //n-1Cr-1: 현재 아이템을 선택한 경우
	        Comb(n-1, r, q);    //n-1Cr: 현재 아이템을 선택하지 않은 경우
	    }
	}
}
