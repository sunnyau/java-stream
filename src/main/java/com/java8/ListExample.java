package exercise;

import java.util.LinkedList;
import java.util.List;

public class ListExample {

	public static void main( String[] args ) {

		//List<String> list = new ArrayList<String>();
		List<String> list = new LinkedList<String>();
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("A");
		list.add("B");
		
		
		System.out.println(list.remove(0));
		System.out.println(list.remove(0));
		System.out.println(list.remove(0));
		System.out.println(list.remove(0));
		System.out.println(list.remove(0));
		
	}
}
