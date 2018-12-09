package com;

import java.util.HashMap;
import java.util.Map;

import com.programmers.SumOfRects.question1retry2;

public class ClassUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		question1retry2 c = new question1retry2();
		Map a = new HashMap<>();
		try {
			a = ClassUtil.getObjSnapshot(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a.get("programmers.level5.super1_a"));
		System.out.println(a.get("programmers.level5.super2_a"));
		System.out.println(a.get("programmers.level5.super2_b"));
		System.out.println(a.get("programmers.level5.super2_c"));
	}

}
