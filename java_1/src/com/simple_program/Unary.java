package com.simple_program;

public class Unary {
public static void main(String[] args) {
	int a=10;
	int b=20;
	
	 a++;//11 post increment 
	 a++;//12 
	 a--;//11 post decrement 
	 a--;//10
	 System.out.println(a);
	 
	/* * System.out.println(a++); 
	 * System.out.println(a--);
	 * System.out.println(++a);
	 * System.out.println(--a);
	 */
	 
	--b;//19 post decrement
	--b;//18
	++b;//19 post increment 
	++b;//20
		
	System.out.println(b);
}
}
