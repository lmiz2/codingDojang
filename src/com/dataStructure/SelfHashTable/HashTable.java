package com.dataStructure.SelfHashTable;

import java.util.ArrayList;

public class HashTable<Character> {

	ArrayList[] list;
	public HashTable(int size) {
		list = new ArrayList[size];
		for(int i = 0; i < size ; i ++) {
			list[i] = new ArrayList<Character>();
		}
	}
	
	public void put(char in) {
		SelfCharacter input = new SelfCharacter(in);
		list[input.hashCode()%list.length].add(in);
		
		for(int i = 0; i < list.length; i++) {
			if(list[i].isEmpty()) {
				System.out.println(i + " : [ ]");
			}else {
				System.out.print(i+" : ");
				for(Object item :list[i]) {
					if(list[i].isEmpty()) {
						System.out.println("[ ]");
					}else {
						System.out.print("["+(Character)item+"] ");
					}
					
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	class SelfCharacter{
		char i;
		SelfCharacter(char c) {
			// TODO Auto-generated constructor stub
			i = c;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			int a = i;
			int b = a *10;
			int c = a *100;
			a = a * 31 ;
			a = (b*31) + a ;
			a = (c*31) + a ;
			return  a;
		}
	}
}
