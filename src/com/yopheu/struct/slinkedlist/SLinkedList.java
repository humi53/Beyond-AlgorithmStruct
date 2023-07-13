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

	public E remove() {
		Node<E> headNode = head;
		if(headNode == null)
			throw new NoSuchElementException();
		
		E element = headNode.data;
		
		Node<E> nextNode = head.next;
		
		head.data = null;
		head.next = null;
		
		head = nextNode;
		size--;
		
		if(size == 0) {
			tail = null;
		}
		return element;
	}
	
	@Override
	public E remove(int index) {
		if(index == 0) {
			return remove();
		}
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> prevNode = search(index - 1);	// 삭제할 노드의 이전 노드
		Node<E> removeNode = prevNode.next;		// 삭제할 노드
		Node<E> nextNode = removeNode.next;		// 삭제할 노드의 다음 노드
		
		E element = removeNode.data; 	// 삭제할 노드의 데이터 반환준비
		
		// 이전 노드가 가리키는 노드를 삭제하려는 다음 노드로 변경
		prevNode.next = nextNode;
		
		// 만약 삭제했던 노드가 마지막 노드라면 tail 을 prevNode로 갱신
		if(prevNode.next == null) {
			tail = prevNode;
		}
		
		// 데이터 삭제
		removeNode.next = null;
		removeNode.data = null;
		size--;
		
		return element;
	}
	@Override
	public boolean remove(Object value) {
		Node<E> prevNode = head;
		boolean hasValue = false;	// ? 사용하려다 사용 못한듯....
		Node<E> x = head;	// removedNode 탐색변수

		// value 와 일치하는 노드를 찾는다
		for(; x != null; x = x.next) {
			if(value.equals(x.data)) {
				hasValue = true;
				break;
			}
			prevNode = x;
		}
		
		// 일치하는 요소가 없을 경우 false 반환
		if(x == null) {
			return false;
		}
		
		// 삭제하려는 노드가 head라면 기존 remove()를 사용
		if(x.equals(head)) {
			remove();
			return true;
		} else {
			// 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
			prevNode.next = x.next;
			
			// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
			if(prevNode.next == null) {
				tail = prevNode;
			}
			x.data = null;
			x.next = null;
			size--;
			return true;
		}
	}

	@Override
	public E get(int index) {
		return search(index).data;
	}

	@Override
	public void set(int index, E value) {
		Node<E> replaceNode = search(index);
		replaceNode.data = null;
		replaceNode.data = value;
	}

	@Override
	public boolean contains(Object value) {
		return indexOf(value) >= 0;
	}

	@Override
	public int indexOf(Object value) {
		int index = 0;
		
		for(Node<E> x = head; x != null; x = x.next) {
			if(value.equals(x.data)) {
				return index;
			}
			index++;
		}
		// 찾고자 하는 요소를 찾지 못했을 경우 -1 반환
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for(Node<E> x = head; x != null;) {
			Node<E> nextNode = x.next;
			x.data = null;
			x.next = null;
			x = nextNode;
		}
		head = tail = null;
		size = 0;
	}

}
