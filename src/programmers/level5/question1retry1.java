//package programmers.level5;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class question1retry1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution sol = new Solution();
//		int[][] rtg = {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
//		int[][] rtg2 = new makeTestCase().get();
////		long[][] rtg = {{1, 1, 6, 5}};
//		sol.solution(rtg);
//	}
//
//}
//
//class makeTestCase{
//	int[][] cases;
//	public makeTestCase() {
//		// TODO Auto-generated constructor stub
//		List<int[]> list = new ArrayList<int[]>();
//		Random rnd = new Random();
//		for(int i = 0; i < 1000 ; i++) {
//			rnd.nextInt(50000);
//			int[] t = {rnd.nextInt(50000),rnd.nextInt(50000),rnd.nextInt(50000)+50000,rnd.nextInt(50000)+50000};
//			list.add(t);
//		}
//		cases =  list.toArray(new int[500][]);
//	}
//	
//	public int[][] get(){
//		return cases;
//	}
//}
//
//class Solution {
//    public long solution(int[][] rectangles) {
//        long answer = -1;
//        resultObj result = new resultObj();
//        int i = 0;
//        for(int[] tmp : rectangles) {
//        	System.out.println("loops"+i++);
//        	long e = getExtent(tmp, result);
//        }
//        System.out.println(result.getTotalExtent());
//        return result.getTotalExtent();
//    }
//    
//    public long getExtent(int[] tmp, resultObj result){
//        if(tmp.length != 4) {
//        	return -1;
//        }
//        result.setRect(tmp);
//        
//		return (tmp[2]-tmp[0])*(tmp[3]-tmp[1]);
//    }
//
//}
//
//class resultObj {
//	long totalExtent = 0;
//	long dupExtent = 0;
//	List<Rectangle> rects = null;
//	
//	public resultObj() {
//		// TODO Auto-generated constructor stub
//		rects = new ArrayList<Rectangle>();
//	}
//	
//	public void setRect(int[] rect) {
//		Long[] ld = {(long)rect[0],(long)rect[1]};
//		Long[] lu = {(long)rect[0],(long)rect[3]};
//		Long[] rd = {(long)rect[2],(long)rect[1]};
//		Long[] ru = {(long)rect[2],(long)rect[3]};
//		Rectangle tmp = new Rectangle(ld, lu, rd, ru);
//		totalExtent += tmp.getWide();
//		List<Rectangle> tmpRects = new ArrayList<Rectangle>();
//		if(rects.size() >= 1) {
//			for(Rectangle r : this.rects) {
//				
//				if(r.getLeft() >= tmp.getRight() || r.getRight() <= tmp.getLeft() || r.getBottom() >= tmp.getTop() || r.getTop() <= tmp.getBottom()) {
//					continue;//안 겹치는경우.
//				}
//				if(r.isDoPlus()) {
//					Long garo;
//					Long sero;
//					if(r.getLeft() < tmp.getLeft()) {
//						if(r.getRight() < tmp.getRight()) {
//							garo = r.getRight() - tmp.getLeft();
//						} else {
//							garo = tmp.getRight() - tmp.getLeft();
//						}
//					}else if(r.getLeft() > tmp.getLeft()){
//						if(r.getRight() > tmp.getRight()) {
//							garo = tmp.getRight() - r.getLeft();
//						} else {
//							garo = r.getRight() - r.getLeft();
//						}
//					}else {//왼쪽선이 같을때
//						if(r.getRight() < tmp.getRight()) {
//							garo = r.getRight() - r.getLeft();
//						}else {
//							garo = tmp.getRight() - tmp.getLeft();
//						}
//					}
//					
//					if(r.getBottom() < tmp.getBottom()) {
//						if(r.getTop() < tmp.getTop()) {
//							sero = r.getTop() - tmp.getBottom();
//						} else {
//							sero = tmp.getTop() - tmp.getBottom();
//						}
//					}else if(r.getBottom() > tmp.getBottom()){
//						if(r.getTop() > tmp.getTop()) {
//							sero = tmp.getTop() - r.getBottom();
//						} else {
//							sero = r.getTop() - r.getBottom();
//						}
//					}else {
//						if(r.getTop() < tmp.getTop()) {
//							sero = r.getTop() - r.getBottom();
//						}else {
//							sero = tmp.getTop() - tmp.getBottom();
//						}
//					}
//					
//					Long dupWD = garo * sero;
//					this.totalExtent += dupWD;
//					continue;
//				}
//				
//				Long garo;
//				Long sero;
//				Long[] ld2 = new Long[2];
//				Long[] rd2 = new Long[2];
//				Long[] lu2 = new Long[2];
//				Long[] ru2 = new Long[2];
//				
//				if(r.getLeft() < tmp.getLeft()) {
//					if(r.getRight() < tmp.getRight()) {
//						garo = r.getRight() - tmp.getLeft();
//						ld2[0] = tmp.getLeft();
//						lu2[0] = tmp.getLeft();
//						rd2[0] = r.getRight();
//						ru2[0] = r.getRight();
//					} else {
//						garo = tmp.getRight() - tmp.getLeft();
//						ld2[0] = tmp.getLeft();
//						lu2[0] = tmp.getLeft();
//						rd2[0] = tmp.getRight();
//						ru2[0] = tmp.getRight();
//					}
//				}else if(r.getLeft() > tmp.getLeft()){
//					if(r.getRight() > tmp.getRight()) {
//						garo = tmp.getRight() - r.getLeft();
//						ld2[0] = r.getLeft();
//						lu2[0] = r.getLeft();
//						rd2[0] = tmp.getRight();
//						ru2[0] = tmp.getRight();
//					} else {
//						garo = r.getRight() - r.getLeft();
//						ld2[0] = r.getLeft();
//						lu2[0] = r.getLeft();
//						rd2[0] = r.getRight();
//						ru2[0] = r.getRight();
//					}
//				}else {//왼쪽선이 같을때
//					if(r.getRight() < tmp.getRight()) {
//						garo = r.getRight() - r.getLeft();
//						ld2[0] = r.getLeft();
//						lu2[0] = r.getLeft();
//						rd2[0] = r.getRight();
//						ru2[0] = r.getRight();
//					}else {
//						garo = tmp.getRight() - tmp.getLeft();
//						ld2[0] = tmp.getLeft();
//						lu2[0] = tmp.getLeft();
//						rd2[0] = tmp.getRight();
//						ru2[0] = tmp.getRight();
//					}
//				}
//				//--------------------------sero----------------------------
//				if(r.getBottom() < tmp.getBottom()) {
//					if(r.getTop() < tmp.getTop()) {
//						sero = r.getTop() - tmp.getBottom();
//						ld2[1] = tmp.getBottom();
//						lu2[1] = r.getTop();
//						rd2[1] = tmp.getBottom();
//						ru2[1] = r.getTop();
//					} else {
//						sero = tmp.getTop() - tmp.getBottom();
//						ld2[1] = tmp.getBottom();
//						lu2[1] = tmp.getTop();
//						rd2[1] = tmp.getBottom();
//						ru2[1] = tmp.getTop();
//					}
//				}else if(r.getBottom() > tmp.getBottom()){
//					if(r.getTop() > tmp.getTop()) {
//						sero = tmp.getTop() - r.getBottom();
//						ld2[1] = r.getBottom();
//						lu2[1] = tmp.getTop();
//						rd2[1] = r.getBottom();
//						ru2[1] = tmp.getTop();
//					} else {
//						sero = r.getTop() - r.getBottom();
//						ld2[1] = r.getBottom();
//						lu2[1] = r.getTop();
//						rd2[1] = r.getBottom();
//						ru2[1] = r.getTop();
//					}
//				}else {
//					if(r.getTop() < tmp.getTop()) {
//						sero = r.getTop() - r.getBottom();
//						ld2[1] = r.getBottom();
//						lu2[1] = r.getTop();
//						rd2[1] = r.getBottom();
//						ru2[1] = r.getTop();
//					}else {
//						sero = tmp.getTop() - tmp.getBottom();
//						ld2[1] = tmp.getBottom();
//						lu2[1] = tmp.getTop();
//						rd2[1] = tmp.getBottom();
//						ru2[1] = tmp.getTop();
//					}
//				}
//				
//				Long dupWD = garo * sero;
//				this.totalExtent -= dupWD;
//				Rectangle dupRect = new Rectangle(ld2, lu2, rd2, ru2);
//				dupRect.setDoPlus(true);
//				tmpRects.add(dupRect);
//			}
//		}
//		rects.add(tmp);
//		rects.addAll(tmpRects);
//	}
//	
//	public long getTotalExtent() {
//		return totalExtent;
//	}
//	public void setTotalExtent(long totalExtent) {
//		this.totalExtent += totalExtent;
//	}
//	public long getDupExtent() {
//		return dupExtent;
//	}
//	public void setDupExtent(long dupExtent) {
//		this.dupExtent += dupExtent;
//	}
//
//	public List<Rectangle> getRects() {
//		return rects;
//	}
//}
//
//class Rectangle{
//	Long[] ld = null;
//	Long[] lu = null;
//	Long[] rd = null;
//	Long[] ru = null;
//	Long wide = null;
//	boolean doPlus = false;
//	public Rectangle(Long[] ld, Long[] lu, Long[] rd, Long[] ru) {
//		super();
//		this.ld = ld;
//		this.lu = lu;
//		this.rd = rd;
//		this.ru = ru;
//		this.wide = (lu[1] - ld[1]) * (rd[0] - ld[0]);
//	}
//	
//	public boolean isDoPlus() {
//		return doPlus;
//	}
//
//	public void setDoPlus(boolean doPlus) {
//		this.doPlus = doPlus;
//	}
//
//	public Long getWide() {
//		return wide;
//	}
//
//	public Long[] getLd() {
//		return ld;
//	}
//
//	public void setLd(Long[] ld) {
//		this.ld = ld;
//	}
//
//	public Long[] getLu() {
//		return lu;
//	}
//
//	public void setLu(Long[] lu) {
//		this.lu = lu;
//	}
//
//	public Long[] getRd() {
//		return rd;
//	}
//
//	public void setRd(Long[] rd) {
//		this.rd = rd;
//	}
//
//	public Long[] getRu() {
//		return ru;
//	}
//
//	public void setRu(Long[] ru) {
//		this.ru = ru;
//	}
//	
//	public Long getLeft() {
//		return ld[0];
//	}
//	
//	public Long getRight() {
//		return ru[0];
//	}
//	
//	public Long getTop() {
//		return ru[1];
//	}
//	
//	public Long getBottom() {
//		return ld[1];
//	}
//}