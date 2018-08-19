package com.dataStructure.SelfLinkedList;

public class LInkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	public LInkedList() {
		head = null;
		tail = null;
	}
	
	public void add(Object in) {
		if(size == 0) {
			head = new Node(in);
			tail = head;
		}else {
			tail.next = new Node(in);
			tail = tail.next;
		}
		size++;
	}
	
	public void delete(Object in) {
		
	}
	
	public String toString() {
		StringBuffer br = new StringBuffer();
		Node tmp = null;
		for(int i = 0 ; i < size ; i++) {
			if(i == 0) {
				tmp = head;
			}else {
				tmp = tmp.next;
			}
			br.append((String)tmp.getData()+" - ");
		}
		return br.toString();		
	}
}

class Node{
	Object data;
	Node next;
	Node(Object input){
		data = input;
		next = null;
	}
	
	public Object getData() {
		return data;
	}
		
}
