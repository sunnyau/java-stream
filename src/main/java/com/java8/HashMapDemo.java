package exercise;

import java.util.*;
class HashMapDemo {
	public static void main(String args[]) {
		// Create a hash map
		Map hm = new HashMap<String,Double>();
		// Put elements to the map
		hm.put("John Doe", new Double(3434.34));
		hm.put("Tom Smith", new Double(123.22));
		hm.put("Jane Baker", new Double(1378.00));
		hm.put("Todd Hall", new Double(99.22));
		hm.put("Ralph Smith", new Double(-19.08));
		// Get a set of the entries
		Set set = hm.entrySet();
		// Get an iterator
		Iterator i = set.iterator();
		// Display elements
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());			
		}

		
		System.out.println();
	}
}
