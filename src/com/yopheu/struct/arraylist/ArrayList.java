package com.yopheu.struct.arraylist;

import java.util.Arrays;

import com.yopheu.struct.List;

public class ArrayList<E> implements List<E>{

	private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기
	private static final Object[] EMPTY_ARRAY = {}; //빈 배열
	private int size; 	// 요소개수
	Object[] array; 	// 요소를 담을 배열
	
	public ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
	
	private void resize(){
		int array_conpacity = array.length;
		// if array's capacity is 0
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		// 용량이 꽉 찰 경우
		if(size == array_conpacity) {
			int new_capacity = array_conpacity * 2;
			array = Arrays.copyOf(array, new_capacity);
			return;
		}
		// 용적의 절반 미만으로 요소가 차지하고 있을 경우
		if(size < (array_conpacity / 2)) {
			int new_capacity = array_conpacity / 2;
			array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
			return;
		}
	}
	
	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}
	
	public void addLast(E value) {
		// 꽉차있는 상태라면 용적 재할당
		if(size == array.length) {
			resize();
		}
		array[size] = value;	// 마지막 위치에 요소 추가
		size++;	// 사이즈 1 증가
	}

	@Override
	public void add(int index, E value) {
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
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
