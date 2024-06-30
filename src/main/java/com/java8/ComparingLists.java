package exercise;

import java.util.*;

public class ComparingLists {

	public static int MAX = 100 ;

	public ComparingLists() {}

	private void addItems( List<String> list ) {
		if ( list != null ) {
			for ( int i = 0 ; i < MAX ; i++ ) {
				list.add( "" + i ) ;
			}
		}
	}
	public void loopList( List<String> list ) {
		System.out.println( list.getClass().getName() ) ;
		addItems( list ) ;		
		for ( Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
			System.out.println( iter.next() );
		}
	}

	public static void main( String[] args ) {
		ComparingLists comparingLists = new ComparingLists();
		// loop arrayList
		comparingLists.loopList( new ArrayList<String>() );
		System.out.println("=======") ;
		comparingLists.loopList( new LinkedList<String>() );
	}

}