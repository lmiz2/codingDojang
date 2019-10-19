package com.backjun.bitMasking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11723 {
	/*
	 * 이 문제에서 배운점
	 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 * StringTokenizer st = new StringTokenizer(br.readLine()); // 1줄당 한번씩, 여러줄이면 반복 생성자 호출
	 * 
	 * Scanner보다 BufferedReader를 이용하는게 약 4배정도 빨랐다.
	 * 입력받아야하는 횟수가 많다면 BufferedReader를 이용하자. 
	 * 
	 * 출력의 경우엔 sysout을 일일이 쓰기보단 StringBuffer나 BufferedWriter를 이용하여 모아서 출력하자.
	 */

	public static void main(String[] args) throws IOException{
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int bits = 0;
		int cmdCnt = Integer.parseInt(st.nextToken());
//		StringBuffer sb = new StringBuffer();
		while (cmdCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			char op = st.nextToken().charAt(1);			
			switch(op) {
			case 'd' : //add x
				bits |= 1<<Integer.parseInt(st.nextToken());				
				break;
			case 'l' : // all
				bits = 2097151;
				break;
			case 'e' : // remove x
				bits &= ~(1<<Integer.parseInt(st.nextToken()));
				break;
			case 'h' : // check x
				if((bits&1<<Integer.parseInt(st.nextToken())) > 0) bw.write(1+"\n");//sb.append(1+"\n");
				else bw.write(0+"\n");//sb.append(0+"\n");
				break;
			case 'o' : // toggle x
				int x = Integer.parseInt(st.nextToken());
				if((bits&1<<x) > 0) {
					bits &= ~(1<<x);
				}else {
					bits |= 1<<x;
				}
				break;
			default : // empty
				bits = 0;
				break;
			}
		}
		bw.flush();
		bw.close();
//		System.out.println(sb.toString());
	}

}