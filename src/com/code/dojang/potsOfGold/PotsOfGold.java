package com.code.dojang.potsOfGold;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class PotsOfGold {

	/**
	 * 
	 *A, B �θ��� �÷��̾ �ִ�.

		�Ѱ��� �� ���� �������� �� �׾Ƹ��� ������ �ִ�. �� �׾Ƹ��� ��ȭ�� ��� �ִ�. (�÷��̾�� �� �׾Ƹ��� ���� ��ȭ�� ����ִ��� �� �� �ִ�.) �� �÷��̾�� ����� ���� �����ִ� ���� �����ڸ� �׾Ƹ� �߿��� �� ���� ���� �� �� �ִ�. (���� ���� �׾Ƹ� �Ǵ� ���� ���� �׾Ƹ� �� �ϳ��� �����ؾ� �Ѵ�.)
		
		��� �׾Ƹ� ������ ���� �� ���� ���� ��ȭ�� ������ �÷��̾ �¸��ϰ� �ȴ�.
		
		�� ������ ��ǥ�� A�� ���� ������ ������ �� A�� ���� ����(Maximize) ��ȭ�� ���� �� �ֵ��� �ϴ� ���̴�. B ���� ������ �˰������� �׾Ƹ��� �����Ѵٰ� �����Ѵ�.
		
		A�� �̱� �� �ִ� �ּ��� ������ ã�� ���ÿ�.
		
		�׸��� �̰��� ���α׷��� �ڵ�� �ۼ� �� ���ÿ�. 
	 *
	 */
	public static double log2(double x) {
	    return Math.log(x) / Math.log(2);
	 }
	
	public static void main(String[] args) {
		String[] loadingSkin = {"-","\\","|","/"};
		
		
		Versus2 v = new Versus2();		
		Player2 A = new Player2(v);
		Player2 B = new Player2(v);
		int playCount = 10000;
		for(int i = 0; i < playCount ; i++) {
			System.out.println("Loading.."+loadingSkin[i%4]+"  "+((float)i/(float)playCount)*100+"%");
			while(true) {
				try {
					A.run();
					B.run();
				}catch(NullPointerException e) {
//					System.out.println(A.getCoinCount());
//					System.out.println(B.getCoinCount());
					if(A.getCoinCount() > B.getCoinCount()) {
						A.setWins(1);
					}else if (A.getCoinCount() < B.getCoinCount()) {
						B.setWins(1);
					}
					v = new Versus2();
					A.init(v);
					B.init(v);
					break;
				}
			}
			if(i == playCount-1) {
				System.out.println("Loading.."+loadingSkin[(i+1)%4]+"  "+((float)(i+1)/(float)playCount)*100+"%");
			}
		}
		double winRating = (float)A.getWins()/(float)playCount *100;
		System.out.println(A.getWins()+" : "+B.getWins());
		System.out.println("A �� �·� : "+ winRating +"%");
		
	}

	
	
}

class Pot2{
	private int goldCoin = 0;

	public int getGoldCoin() {
		return goldCoin;
	}

	Pot2(){
		this.goldCoin = new Random().nextInt(10000000);
	}
}

class Player2{
	int coinCount = 0;
	int wins = 0;
	Versus2 cls;
	
	Player2(Versus2 q){
		this.cls = q;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins += wins;
	}
	
	public int getCoinCount() {
		return coinCount;
	}
	
	public void init(Versus2 v) {
		this.cls = v;
		coinCount = 0;
	}

	public void setCoinCount(int coinCount) {
		this.coinCount += coinCount;
	}
	
	public int calCost(String path, Deque line) {//path�� ���� ��� ���ʸ� ������� ����Ű�� 0�Ǵ� 1�� �������� ��Ʈ��. 1�� ����, 0�� ������ �׾Ƹ��� Get 
		Deque<Pot2> tmpLine = new LinkedBlockingDeque<Pot2>();
		tmpLine.addAll(line);
		int mySum = 0;
		int otherSum = 0;
		for(int i = 0; i < tmpLine.size(); i ++) {
			if(i%2 == 1) {//��������϶�
				if(path.charAt(i) =='1') {
					otherSum += tmpLine.pollFirst().getGoldCoin();					
				}else if (path.charAt(i) =='0') {
					otherSum += tmpLine.pollLast().getGoldCoin();					
				}
			}else {//�� �����϶�
				if(path.charAt(i) =='1') {
					mySum += tmpLine.pollFirst().getGoldCoin();					
				}else if (path.charAt(i) =='0') {
					mySum += tmpLine.pollLast().getGoldCoin();					
				}
			}
		}
		return mySum;		
	}
	
	public int thinking(Deque line) {//��� ����Ǽ� ��� ��  ���� ���� �ڽ�Ʈ ������ ����
		StringBuffer path = new StringBuffer();
		Map<String, Integer> costs = new HashMap<>();//<pathString, totalCost>
		for(int i = 1 ; i < (int)Math.pow(2, line.size()+1); i++) {// ��� ����� �� path ���
			StringBuffer path2 = new StringBuffer();
			for(int p = 0 ; p <(int)PotsOfGold.log2((int)Math.pow(2, line.size())) - (int)PotsOfGold.log2(i); p++) {
				path2.append("0");
			}
			path2.append(Integer.toBinaryString(i));
			costs.put(path2.toString(), calCost(path2.toString(),line));
		}

		for(String key : costs.keySet()) {
			Integer val = costs.get(key);
		}
		
		List<Map.Entry<String, Integer>> maxs = new ArrayList<Map.Entry<String, Integer>>();
		Map.Entry<String, Integer> maxEntry = null;
		for (Map.Entry<String, Integer> entry : costs.entrySet()) {

		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
		    	maxs = new ArrayList<Map.Entry<String, Integer>>();
		    	maxEntry = entry;
		    	//compareTo�� �̿��� ���� ���� map���� maxEntry�� �����
		    }else if (maxEntry.getValue().compareTo(entry.getValue())==0) {
		    	maxs.add(entry);
		    }
		}
		int matched0 = 0;
		int matched1 = 0;
		for(Map.Entry<String, Integer> e : maxs) {
			if(e.getKey().charAt(0) =='0') {
				matched0++;
			}else {
				matched1++;
			}
		}
		if(matched0 > matched1) {
			return 0;
		}else {
			return 1;
		}
		
		 //1�� �����ʲ� ����, -1�� ���ʲ� ����
	}
	
	public void run() {
		int determine = 0;
		determine = thinking(cls.line);
		this.setCoinCount(cls.getPot2Coin(determine).getGoldCoin());
	}
}

class Versus2{
	Deque<Pot2> line;
	int potCount = 8;
	Versus2(){

		line = new LinkedBlockingDeque();
		
		for(int i = 0; i  < potCount; i++) {
			line.add(new Pot2());			
		}
//		printCurrLine();
	}
	public synchronized Pot2 getPot2Coin(int direction) {
		if(direction >0) {
			return (Pot2) line.pollFirst();
		}else {
			return (Pot2) line.pollLast();			
		}
	}
	
	public void printCurrLine() {
		for(Pot2 p : line) {
			System.out.print("-"+p.getGoldCoin()+"-");
		}
		System.out.println();
	}
	
	
}
