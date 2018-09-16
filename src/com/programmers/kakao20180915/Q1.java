package com.programmers.kakao20180915;

import java.util.HashMap;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] in = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan", "Leave uid4567 Ryan"};
		s.solution(in);
	}

}
//class Solution {
//	public static String inMsg = "님이 들어왔습니다.";
//	public static String outMsg = "님이 나갔습니다.";
//	
//    public String[] solution(String[] record) {
//        String[] answer = new String[record.length];
//        String[] rAnswer;
//        
//        HashMap<String, String> lastNMs = new HashMap<String, String>();// key : uuid , value : last NickName
//        int cnt = 0;
//        for(int i = 0 ; i < record.length; i++) {
//        	if(record[i].charAt(0) == 'C') {//Change
//        		lastNMs.put(getUUID(record[i]), getNNM(record[i]));
//        	}else if(record[i].charAt(0) == 'E'){//Enter
//        		lastNMs.put(getUUID(record[i]), getNNM(record[i]));
//        		answer[cnt] = getUUID(record[i])+";"+inMsg; 
//            	cnt++;
//        	}else {//Leave
//        		answer[cnt] = getUUID(record[i])+";"+outMsg;
//            	cnt++;
//        	}
//        }
//        
//        rAnswer = new String[cnt];
//        
//        for(int i = 0; i < cnt; i++) {
//        	rAnswer[i] = lastNMs.get(answer[i].split(";")[0]) + answer[i].split(";")[1];
//        }
//        answer = null;
//        return rAnswer;
//    }
//    
//    public String getUUID(String str) {
//    	return str.split(" ")[1];
//    }
//    
//    public String getNNM(String str) {
//    	return str.split(" ")[2];
//    }
//}