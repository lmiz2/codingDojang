package com.macro;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Macro1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r;
		try {
			r = new Robot();
			System.out.println("start");
			Thread.sleep(10000);
			
			r.keyPress(KeyEvent.VK_UP);
			r.keyPress(KeyEvent.VK_ENTER);
			
			
			System.out.println("END");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
