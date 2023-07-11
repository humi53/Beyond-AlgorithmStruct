package com.yopheu.struct.arraylist;

import com.yopheu.struct.List;

public class ExecArrayList {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			myList.add(i);
		}
		
		// iterable 을 구현하지 않아서 사용 불가
//		for (int num : myList) {
//			
//		}
		myList.toString();	// 구현 필요
		for(int i = 0; i < myList.size(); i ++) {
			System.out.println(myList.get(i));
		}
	
	}
}
