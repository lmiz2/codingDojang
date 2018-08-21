package com.backjun.KIO;

public class Q2661 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] str = new int[n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 1; j <= 3; j++) {
				if(i == 0) {
					str[i] = j;
					break;
				}else if (i < 2){
					if(str[i-1] != j) {
						str[i] = j;
						break;
					}
				}else{
					if(str[i-2] != j && str[i-1] != j) {
						str[i] = j;
						break;
					}else {
						if(str[i-1] != j) {
							str[i] = j;
							break;
						}
					}
				}
			}
		}
		for(int i = 0; i < 5 ; i ++) {
			System.out.print(str[i]);
		}
	}

}

