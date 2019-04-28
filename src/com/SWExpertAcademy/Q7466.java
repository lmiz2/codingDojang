package com.SWExpertAcademy;

import java.util.Scanner;

public class Q7466 {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer answers = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int caseCnt = sc.nextInt();
		for(int i = 0 ; i < caseCnt ; i ++) {
			int a,b;
			boolean flag = false;
			a = sc.nextInt();
			b = sc.nextInt();
						
			Comb1 c = new Comb1(a, b);
			flag = c.doit();
			
			if(flag) {
				answers.append("#"+(i+1)+" "+b+"\n");
			}else {

				long ap = 1;
				for(int j = 1; j <= a; j++) {
					ap *= j;
				}
				answers.append("#"+(i+1)+" "+gcd(ap,b)+"\n");					
			
			}
		}
		System.out.println(answers.toString());
	}
	public static long gcd(long a, long b) {
		if(a%b==0) {
			return b;
		}else {
			return gcd(b,a%b);
		}
	}

}

class Comb1 {

	int[] T;
	int[] data;
	long rtn;
	int a,b;
	public Comb1(int a, int b) {
		// TODO Auto-generated constructor stub
		this.T = new int[a];
		this.data = new int[a];
		this.a = a;
		this.b = b;
		for(int i = 0; i < a; i++) {
			data[i] = i+1;
		}		
	}
	
	public boolean doit() {
		for(int i = 1; i <= a; i++) {
//			System.out.println(i);
			if(Comb(a,i,i)) {
				return true;
			}
		}
		return false;
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Comb b = new Comb();
//		b.T = new int[10];
//		b.data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//		b.Comb(10, 3, 3);
//
//	}
	
	boolean process(int q){
		rtn = 1;
	    for(int i = q-1; i>= 0; i--){
	    	if(T[i] != 0)
	    		rtn *= T[i];
//	            System.out.printf("%d ", T[i]);
	    }
//	    System.out.println(rtn);
	    if(rtn == b) {
	    	return true;
	    }
	    else
	    	return false;
	}

	boolean Comb(int n, int r, int q){
	    if(r == 0){	        
	        return process(q);
	    }else if(n<r){
	        return false;
	    }
	    else { 
	        T[r-1] = data[n-1];
	        if(!Comb(n-1, r-1, q)) {
	        	Comb(n-1, r, q);
//	        	System.out.println("cc");
	        }else return false;
	    }
	    return false;
	}
}