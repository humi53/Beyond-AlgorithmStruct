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
		int array_capacity = array.length;
		// if array's capacity is 0
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		// 용량이 꽉 찰 경우
		if(size == array_capacity) {
			int new_capacity = array_capacity * 2;
			array = Arrays.copyOf(array, new_capacity);
			return;
		}
		// 용적의 절반 미만으로 요소가 차지하고 있을 경우
		if(size < (array_capacity / 2)) {
			int new_capacity = array_capacity / 2;
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
		if(index > size || index < 0) {		// index가 영역을 벗어날 경우 예외 발생
			throw new IndexOutOfBoundsException();
		}
		if(index == size) {		// 마지막 위치면 addLast 메소드 이용
			addLast(value);
		} else {
			if(size == array.length) {		// 꽉차면 용적 재할당
				resize();
			}
			// index 기준 뒤에 있는 모든 요소를 한칸씩 뒤로 밀기
			for(int i = size; i > index; i--) {
				array[i] = array[i - 1];
			}
			array[index] = value; 	// index 위치에 요소 할당
			size++;
		}
	}
	
	public void addFirst(E value) {
		add(0, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		E element = (E) array[index];	// 삭제할 요소를 반환하기 위해 담아둠
		array[index] = null;
		
		// 삭제할 요소의 뒤에 있는 요소들을 한칸씩 앞으로
		for(int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
			array[i + 1] = null;
		}
		size--;
		resize();
		return element;
	}

	@Override
	public boolean remove(Object value) {
		int index = indexOf(value);	// 요소로 index 추출
		if(index == -1) {	// -1 요소 없음 처리
			return false;
		}
		remove(index);	// index에 있는 요소 제거
		return true;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index >= size || index < 0) {	// 범위 벗어나면 예외 발생
			throw new IndexOutOfBoundsException();
		}
		// Object 타입에서 E 타입으로 캐스팅 후 반환
		return (E) array[index];
	}

	@Override
	public void set(int index, E value) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			array[index] = value; 	// 해당 위치의 요소를 교체
		}
	}

	@Override
	public boolean contains(Object value) {
		if(indexOf(value) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int indexOf(Object value) {
		int i = 0;
		for (i = 0; i < size; i++) {
			if(array[i].equals(value)) {
				return i;
			}
		}
		return -1;	// 일치하는 값이 없으면 -1 반환
	}
	public int lastIndexOf(Object value) {
		for(int i = size - 1; i >= 0; i--) {
			if(array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;	// 요소가 0개일 경우 비어있다는 의미로 true 반환
	}

	@Override
	public void clear() {
		// 모든 공간을 null 처리 해준다
		for(int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();	// 용적공간을 반으로 줄여준다.
	}

}
