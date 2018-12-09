package com.dataStructure.SelfHashTable;

import java.util.ArrayList;

public class HashTable<T> {

	ArrayList[] list;
	public HashTable(int size) {
		list = new ArrayList[size];
		for(int i = 0; i < size ; i ++) {
			list[i] = new ArrayList<T>();
		}
	}
	
	public void put(char in) {
		SelfT input = new SelfT(in);
		list[input.hashCode()%list.length].add(in);
	}
	
	public void print() {
		for(int i = 0; i < list.length; i++) {
			if(list[i].isEmpty()) {
				System.out.println(i + " : [ ]");
			}else {
				System.out.print(i+" : ");
				for(Object item :list[i]) {
					if(list[i].isEmpty()) {
						System.out.println("[ ]");
					}else {
						System.out.print("["+(T)item+"] ");
					}
					
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	class SelfT{
		char i;
		SelfT(char c) {
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
