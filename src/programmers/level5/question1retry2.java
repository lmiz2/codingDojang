package programmers.level5;

import java.util.ArrayList;
import java.util.List;

public class question1retry2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeTestCase2 mktst = new makeTestCase2();
		Solution2 s = new Solution2();
		s.solution(mktst.get());
	}
	
}
class Solution2 {
    public long solution(int[][] rectangles) {

        long answer = -1;
        int duplicateExtent = 0;
        List<Rect> list = new ArrayList<Rect>();
        for(int[] tmp : rectangles) {
        	list.add(new Rect(tmp));
        	System.out.println(duplicateExtent++);
        	answer += list.get(duplicateExtent-1).getArea();
        }
        list.get(0).printInfo();
        System.out.println(answer);
        System.out.println(10000000000L * 10000000000L);
        return 0;
    }

}

class Rect{
	int width = 0;
	int height = 0;
	int left = 0;
	int right = 0;
	int top = 0;
	int bottom = 0;
	long area = 0L;
	long addArea = 0L;
	
	Rect(int[] in){
		left = in[0];
		right = in[2];
		top = in[3];
		bottom = in[1];
		width = right - left;
		height = top - bottom;
		area = (long)width * (long)height;
		addArea = area;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public long getArea() {
		return area;
	}
	public void setArea(long area) {
		this.area = area;
	}
	
	public long getAddArea() {
		return addArea;
	}
	
	public void printInfo() {
		System.out.println("¿ŞÂÊÁÂÇ¥ : "+left);
		System.out.println("¿À¸¥ÂÊÁÂÇ¥ : "+right);
		System.out.println("¾Æ·¡ÂÊÁÂÇ¥ : "+bottom);
		System.out.println("À§ÂÊÁÂÇ¥ : "+top);
		System.out.println("°¡·Î : "+width);
		System.out.println("¼¼·Î : "+height);
		System.out.println("³ĞÀÌ : "+area);
		
	}
}
