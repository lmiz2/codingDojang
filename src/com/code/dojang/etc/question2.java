package com.code.dojang.etc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class question2 {

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
		Versus v = new Versus();
		
		Player A = new Player(v);
		Player B = new Player(v);
		A.setName("A");
		
		B.setName("B");
		A.start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		B.start();
		
	}

	
	
}

class Pot{
	private int goldCoin = 0;

	public int getGoldCoin() {
		return goldCoin;
	}

	Pot(){
		this.goldCoin = new Random().nextInt(1000000);
	}
}

class Player extends Thread{
	int coinCount = 0;
	int wins = 0;
	Versus cls;
	Player(Versus q){
		this.cls = q;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getCoinCount() {
		return coinCount;
	}

	public void setCoinCount(int coinCount) {
		this.coinCount += coinCount;
		System.out.print(this.toString() +" : get "+coinCount+", total:"+getCoinCount()+"  "); 
		cls.printCurrLine();
	}
	
	public int calCost(String path, Deque line) {//path�� ���� ��� ���ʸ� ������� ����Ű�� 0�Ǵ� 1�� �������� ��Ʈ��. 0�� ����, 1�� ������ �׾Ƹ��� Get 
		Deque<Pot> tmpLine = new LinkedBlockingDeque<Pot>();
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
			for(int p = 0 ; p <(int)question2.log2((int)Math.pow(2, line.size())) - (int)question2.log2(i); p++) {
				path2.append("0");
			}
			path2.append(Integer.toBinaryString(i));
			costs.put(path2.toString(), calCost(path2.toString(),line));
//			System.out.println(path2);
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
//			System.out.println(this.getName()+" : get "+e.getValue()+", path"+e.getKey());
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int determine = 0;
			
			determine = thinking(cls.line);

			try {
				this.setCoinCount(cls.getPotCoin(determine).getGoldCoin());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				break;
			} catch(NullPointerException e) {
				System.out.println(this.getName()+" : My Turn is finished. Total Gold :"+getCoinCount());
				break;
			}
		}
	}
}

class Versus{
	Deque<Pot> line;
	int potCount = 8;
	Versus(){

		line = new LinkedBlockingDeque();
		
		for(int i = 0; i  < potCount; i++) {
			line.add(new Pot());			
		}
		
		printCurrLine();
	}
	public synchronized Pot getPotCoin(int direction) {
		if(direction >0) {
			return (Pot) line.pollFirst();
		}else {
			return (Pot) line.pollLast();			
		}
	}
	
	public void printCurrLine() {
		for(Pot p : line) {
			System.out.print("-"+p.getGoldCoin()+"-");
		}
		System.out.println();
	}
	
	
}
