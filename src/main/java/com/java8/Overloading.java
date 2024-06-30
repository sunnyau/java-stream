package exercise;

public class Overloading {

	static void overloadedMethod(Object o) {
		System.out.println("overloadedMethod(Object) called");
	}

	static void overloadedMethod(String s) {
		System.out.println("overloadedMethod(String) called");
	}

	static void overloadedMethod(Integer i) {
		System.out.println("overloadedMethod(Integer) called");
	}

	public static void main(String[] args) {
		//Object object = new String("abc");
		//overloadedMethod( object );
		overloadedMethod("abc");
	}
}
