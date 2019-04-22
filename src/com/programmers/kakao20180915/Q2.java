package com.programmers.kakao20180915;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] a = {2, 5, 2, 6, 4, 3, 3 };
//		int[] a = {4,4,4,4,4 };
		a = s.solution(5, a);
		
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}

}
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer;
        HashMap<Integer, ArrayList<Integer>> set = new HashMap<>(); 
        for(int i = 1; i <= N+1; i++) {
        	set.put(i, new ArrayList<>());
        }
        for(int i = 0; i < stages.length; i++) {
        	
        	set.get(stages[i]).add(stages[i]);
        }
        
        PriorityQueue<FailStage> answers = new PriorityQueue<FailStage>();
        
        for(int i = 1; i <= N; i ++) {
        	int cnt = 0;
        	for(int j = i; j <= N+1; j++) {
        		cnt += set.get(j).size();
        	}
        	if(set.get(i).size() == 0 && cnt == 0) {
        		continue;
        	}
    		answers.offer(new FailStage(i, (float)set.get(i).size()/cnt ) );
        }        
        answer = new int[answers.size()];
        set = null;
        int i = 0;
        while(!answers.isEmpty()) {
        	answer[i++] = answers.poll().stageNumber;
        }
        
        return answer;
    }
}

class FailStage implements Comparable<FailStage>{
	int stageNumber;
	float failPercent;
	
	public FailStage(int stageNum , float failpercent) {
		// TODO Auto-generated constructor stub
		stageNumber = stageNum;
		failPercent = failpercent;
	}
	
	@Override
	public int compareTo(FailStage o) {
		// TODO Auto-generated method stub
		if(this.failPercent > o.failPercent) {
			return -1;
		}else if(this.failPercent < o.failPercent) {
			return 1;
		}else if (this.failPercent == o.failPercent) {
			if(this.stageNumber > o.stageNumber) {
				return 1;
			}else if (this.stageNumber < o.stageNumber){
				return -1;
			}
			
		}
		return 0;
	}
}