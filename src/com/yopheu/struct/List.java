package com.yopheu.struct;

public interface List<E> {
	/**
	 * 리스트에 요소를 추가합니다
	 * @param value 리스트에 추가할 요소
	 * @return 중복을 허용하지 않을 경우 
	 * 			중복시 {@code false}를 반환,
	 * 			비중복시 {@code true}를 반환.
	 */
	boolean add(E value);
	
	/**
	 * 리스트에 요소를 특정 위치에 추가
	 * 특정위치 이후 요소들은 한칸씩 뒤로 밀림.
	 * @param index 특정위치
	 * @param value 추가할 요소
	 */
	void add(int index, E value);
	
	/**
	 * index 위치의 요소를 삭제
	 * @param index 삭제할 위치.
	 * @return 삭제된 요소를 반환
	 */
	E remove(int index);
	
	/**
	 * 특정 요소를 삭제
	 * @param value 삭제할 요소
	 * @return 삭제요소가 없거나 실패할 경우{@code false}
	 * 			삭제 성공시 {@code true}를 반환
	 */
	boolean remove(Object value);
	
	/**
	 * 특정 위치의 요소를 반환
	 * @param index 접근할 위치
	 * @return index 위치에 있는 요소 반환
	 */
	E get(int index);
	
	/**
	 * 특정 위치에 있는 요소를 새 요소로 대체.
	 * @param index 접근할 위치
	 * @param value 새로 대체할 요소
	 */
	void set(int index, E value);
	
	/**
	 * 리스트에 특정 요소가 있는지 확인
	 * @param value 찾을 특정 요소
	 * @return 해당요소가 존재할 경우{@code true}, 존재하지 않을 경우{@code false}를 반환
	 */
	boolean contains(Object value);
	
	/**
	 * 특정 요소가 몇번째 위치에 있는지 확인
	 * @param value 위치를 찾을 요소
	 * @return 처음으로 요소와 일치하는 위치를 반환
	 * 			만약 일치하는 요소가 없을경우 -1 반환
	 */
	int indexOf(Object value);
	
	/**
	 * 리스트에 잇는 요소 개수를 반환
	 * @return 요소개수
	 */
	int size();
	
	/**
	 * 리스트에 요소가 비어있는지 확인
	 * @return 비어있을 경우 {@code true}, 요소가 있을경우{@code false}를 반환
	 */
	boolean isEmpty();
	
	/**
	 * 리스트에 있는 요소를 모두 삭제
	 */
	public void clear();
}
