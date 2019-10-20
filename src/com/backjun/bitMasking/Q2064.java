package com.backjun.bitMasking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2064 {
	public static void main(String[] args) throws IOException {
		new Solution_Q2064();		
	}

}
class Solution_Q2064{
	
	public Solution_Q2064() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int[][] ips = new int[t][4];
		int[] subnetMask = new int[]{255,255,255,255};
		int[] networkAddr = new int[4];
		int[] minAddr = new int[4];
		int[] maxAddr = new int[4];
		int gap = 0;
		for(int i = 0 ; i < t ; i ++) {
			StringTokenizer token = new StringTokenizer(br.readLine(),".");
			for(int j = 0 ; j < 4 ; j ++) {
				ips[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		boolean subnetEnded = false;
		for(int j = 0 ; j < 4; j ++) {
			int minip = 255;
			int maxip = -1;
			for(int i = 0 ; i < ips.length ; i++) {
				if(ips[i][j] > maxip) maxip = ips[i][j];
				if(ips[i][j] < minip) minip = ips[i][j];
			}
			int gapnumb = maxip - minip;
			int gapbit = 1;
			while(gapbit <= gapnumb) gapbit <<= 1;			
			if(!subnetEnded && gapbit>1) {
				subnetMask[j] -= (gapbit-1);
				subnetEnded = true;
			}
			else if (subnetEnded){
				subnetMask[j] = 0;
			}
			minAddr[j] = minip;
			maxAddr[j] = maxip;	
		}
		
		boolean processed = false;
		for(int i = 0 ; i < 4 ; i ++) {
			if(!processed) {
				if(subnetMask[i] != 255) {
					int smGap = 256 - subnetMask[i];
					int start = 0;
					int end = smGap-1;
					int x = minAddr[i];
					int y = maxAddr[i];
					while(true) {
						if(start <= x && end >= x) {
							networkAddr[i] = start;
							if(!(start <= y && end>= y)){
								subnetMask[i] -= smGap;
							}
							break;
						}
						start += smGap;
						end += smGap;
					}
				}else {
					networkAddr[i] = ips[0][i];
				}
			}else {
				networkAddr[i] = 0;
			}
		}
		for(int i = 0 ; i < 4 ; i ++) {
			bw.write(""+networkAddr[i]);
			if(i != 3) bw.write(".");
		}
		bw.write("\n");
		for(int i = 0 ; i < 4 ; i ++) {
			bw.write(""+subnetMask[i]);
			if(i != 3) bw.write(".");
		}
		bw.write("\n");
		bw.flush();
		
	}	
}
