package com.backjun.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer = new Computer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int i = Integer.parseInt(br.readLine());
			int cnt = 0;
			while(true) {
				cnt++;
				computer.command(br.readLine());
				if(cnt == i) {
					break;
				}
			}
			System.out.println(computer.getRes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Computer {
	Stack<Character> st;
	StringBuffer sbf;
	Computer(){
		sbf = new StringBuffer();		
	}
	
	public void command(String s) {
		st = new Stack<Character>();
		for(int i = 0 ; i < s.length() ; i ++) {
			
			if(s.charAt(i) == '(') {
				this.st.push(s.charAt(i));
			}else {
				if(this.st.isEmpty()) {
					sbf.append("NO\n");
					return;
				}
				this.st.pop();
			}
		}
		if(this.st.isEmpty()) {
			sbf.append("YES\n");
		}else {
			sbf.append("NO\n");
		}
	}
	
	public String getRes() {
		return sbf.toString();
	}
}