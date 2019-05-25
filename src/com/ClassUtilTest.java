package com;

import java.util.HashMap;
import java.util.Map;

import com.SWExpertAcademy.Comb;

public class ClassUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Comb c  = new Comb();
		Map a = new HashMap<>();
		try {
			a = ClassUtil.getObjSnapshot(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
