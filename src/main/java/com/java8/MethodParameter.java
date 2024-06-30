package exercise;

public class MethodParameter {

	public void method( final StringBuffer input ) {
		input.append("hello") ;
	}
	
	public static void main( String[] args ) {
		MethodParameter mp = new MethodParameter();
		StringBuffer input = new StringBuffer("input") ;
		mp.method(input);
		System.out.println(input.toString());
	}
}
