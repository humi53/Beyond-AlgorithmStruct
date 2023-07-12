package com.yopheu.struct.slinkedlist;

import java.util.NoSuchElementException;

import com.yopheu.struct.List;

public class SLinkedList<E> implements List<E> {

	private Node<E> head;	// 노드의 첫 부분
	private Node<E> tail;	// 노드의 마지막 부분
	private int size;	// 요소 개수
	
	public SLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	@SuppressWarnings("unused")
	private Node<E> search(int index){
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> x = head;
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}

	public void addFirst(E value) {
		Node<E> newNode = new Node<E>(value);
		newNode.next = head;
		head = newNode;
		size++;
		
		if(head.next == null) {
			tail = head;
		}
	}
	
	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}

	public void addLast(E value) {
		Node<E> newNode = new Node<E>(value);
		if(size == 0) {
			addFirst(value);
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	@Override
	public void add(int index, E value) {
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			addFirst(value);
			return;
		}
		if(index == size) {
			addLast(value);
			return;
		}
		Node<E> prev_Node = search(index - 1);
		Node<E> next_Node = prev_Node.next;
		Node<E> newNode = new Node<E>(value);
		
		prev_Node.next = null;
		prev_Node.next = newNode;
		newNode.next = next_Node;
		size++;
	}

	@Override
	public E remove(int index) {
		Node<E> headNode = head;
		if(headNode == null)
			throw new NoSuchElementException();
		E element = headNode.data;
		
		Node<E> nextNode = head.next;
		
		head.data = null;
		head.next = null;
		return null;
	}
	@Override
	public boolean remove(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, E value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
