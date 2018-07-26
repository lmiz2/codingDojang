package programmers.level5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class question1 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] rtg = {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
//		int[][] rtg = {{1, 1, 6, 5}};
		sol.solution(new makeTestCase2().get());
		Set<int[]> tiles = new HashSet<int[]>();
		int[] a = {1,1};
		int[] b = {1,2};
		int[] c = {2,2};
		tiles.add(a);
		tiles.add(b);
		tiles.add(a);
		tiles.add(a);
		tiles.add(c);
		tiles.add(a);
		Iterator<int[]> tilesGetter = tiles.iterator();
		
		while(tilesGetter.hasNext()) {
			int[] tmp = tilesGetter.next();
		}
	}

}

class makeTestCase2{
	int[][] cases;
	public makeTestCase2() {
		// TODO Auto-generated constructor stub
		List<int[]> list = new ArrayList<int[]>();
		Random rnd = new Random();
		for(int i = 0; i < 100000 ; i++) {
			rnd.nextInt(50000);
			int[] t = {rnd.nextInt(50000000),rnd.nextInt(50000000),rnd.nextInt(50000000)+50000000,rnd.nextInt(50000000)+50000000};
			list.add(t);
		}
		cases =  list.toArray(new int[100000][]);
	}
	
	public int[][] get(){
		return cases;
	}
}

class Solution {
    public long solution(long[][] rectangles) {
		HashSet<NumberSet> tiles = new HashSet<NumberSet>();
        long answer = -1;
        int duplicateExtent = 0;
        List list = new ArrayList<>();
        for(long[] tmp : rectangles) {
        	list.add(tmp);
        	System.out.println(duplicateExtent++);
        	long[] a = (long[]) list.get(duplicateExtent-1);
        	answer += a[0]*a[1];
//        	System.out.println("in");
//        	int e = getExtent(tmp,tiles);
//        	duplicateExtent += e;
        	
        	
        }
        System.out.println(answer);
//		Iterator<NumberSet> tilesGetter = tiles.iterator();
		
//		while(tilesGetter.hasNext()) {
//			NumberSet tmp = tilesGetter.next();
//			System.out.println(tmp.getN1()+""+tmp.getN2());
//		}
        
        System.out.println("중복 넓이 : "+duplicateExtent);
        System.out.println("종합넓이 : "+tiles.size());
        
        return tiles.size();
    }
    
    public int getExtent(int[] rectangle, HashSet<NumberSet> sets){
        if(rectangle.length != 4) {
        	return -1;
        } 
        
        for(int i = rectangle[1]; i < rectangle[3]; i ++) {//세로 반복
        	for(int j = rectangle[0] ; j < rectangle[2]; j ++) {//가로 반복
            	NumberSet tmp = new NumberSet(j,i);
                sets.add(tmp);
        	}
        }
        
		return (rectangle[2]-rectangle[0])*(rectangle[3]-rectangle[1]);
    }

}

class NumberSet{
	private int n1 = 0;
	private int n2 = 0;
	NumberSet(int n1, int n2){
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	
	@Override
	public int hashCode() {
		String hc = n1+""+n2;
	    return hc.hashCode();

	}	 

	@Override
	public boolean equals(Object obj) {
	        if(!(obj instanceof NumberSet)) {
	            return false;
	        }
	        NumberSet tmp = (NumberSet)obj;
	        if(tmp.getN1() == this.n1 && tmp.getN2() == this.n2) {
	        	return true;
	        }else {
	        	return false;
	        }
	}
}