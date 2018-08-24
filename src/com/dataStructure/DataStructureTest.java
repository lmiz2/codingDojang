package com.dataStructure;

import com.dataStructure.SelfHashTable.HashTable;
import com.dataStructure.SelfLinkedList.LInkedList;

public class DataStructureTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LInkedList list = new LInkedList();
//		list.add("asd");
//		list.add("bsc");
//		list.add("asd1");
//		list.add("bsc2");
//		System.out.println(list.toString());
		
		HashTable<Character> hs = new HashTable<>(10);
		hs.put('c');
		hs.put('a');
		hs.put('z');
		hs.put('f');
	}

}
