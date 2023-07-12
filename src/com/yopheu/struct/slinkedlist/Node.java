package com.yopheu.struct.slinkedlist;

public class Node<E> {
	E data;
	Node<E> next;
	
	Node(E date){
		this.data = date;
		this.next = null;
	}
}
