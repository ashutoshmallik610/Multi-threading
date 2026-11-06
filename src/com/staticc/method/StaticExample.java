package com.staticc.method;

public class StaticExample {
	
	static int printNumb() {
		
		System.out.println("Hello");
		
		return 1;
	}
	
	static int value = printNumb();
	
	public static void main(String[] args) {
		
	}

}
