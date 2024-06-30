package com.java8;

import java.net.*;
import java.io.*;
import java.lang.* ;
import java.util.* ;

// Submitted by : Sunny Au

public class ReadWebPageV2 {
	
	public static final String OPEN_CONTENT = "<content" ;
	public static final String CLOSE_CONTENT = "</content>" ;
	public static final String SPACE = " ";
	public static final String COMMA = ",";
	
	// construtor 		
	public ReadWebPageV2() {} ;
	
	/**
	 * Read a webpage and put its information into a string.
	 */
	 public StringBuilder readHttpToString( String httpFeeds ) throws IOException {
        	URL url = new URL(httpFeeds);
        	URLConnection connection = url.openConnection();
        	BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                connection.getInputStream()));
                String inputLine;

                // to put all readLine content into StringBuilder
                StringBuilder stringBuilder = new StringBuilder() ;
                
                while ((inputLine = in.readLine()) != null) {
                	stringBuilder.append(inputLine);                
                }
                in.close();
                
                return stringBuilder ;
	}
	
	/**
	 * stringBuilder contains content tags. 
	 * Return a string that only contains these extracted contents.
	 */
	public String extractContent( StringBuilder stringBuilder ) {
		int openContentIndex = 0 ;
        int closeContentIndex = 0 ;
                
        StringBuilder returnString = new StringBuilder() ;
                
        while ( openContentIndex != -1 ) {
               	
            openContentIndex = stringBuilder.indexOf(OPEN_CONTENT);
            closeContentIndex = stringBuilder.indexOf(CLOSE_CONTENT);
                	             	
            if ( openContentIndex != -1 && closeContentIndex != -1 ) {
            	// add content into returnString
            	returnString.append( stringBuilder.substring( openContentIndex, closeContentIndex ) ) ;
            	// cut out the content information, including those before the content and search again.
            	stringBuilder = stringBuilder.delete( 0, closeContentIndex + CLOSE_CONTENT.length()  ) ;
            }        	
        }
        return returnString.toString() ;
	}

	/**
	 * Put excludeWords, separated by comma into a set
	 */
	public Set<String> getExcludedWordsSet( String excludeWords ) {
		
    	    Set<String> excludeWordsSet = new HashSet<String>();   	    
    	    Scanner excludeWordsScanner = new Scanner(excludeWords) ; 
    	    excludeWordsScanner.useDelimiter(COMMA);
    	    
    	    while ( excludeWordsScanner.hasNext() ) {
    	    	      excludeWordsSet.add( excludeWordsScanner.next() );
    	    	      
    	    }   	   
    	    excludeWordsScanner.close() ;
    	    return excludeWordsSet;		
	}
	
	/**
	 * Read in feedContent and break it down into words, separated by space.
	 * We only count the words that are not in excludedWordsSet.
	 * Return a map that holds the words and how many times they appear.
	 */
	public Map<String,Integer> getWordCountMap( String feedContent, Set<String> excludeWordsSet ) {
		   	Map<String,Integer> map = new HashMap<String,Integer>();
    	    
    	    Scanner scanner = new Scanner( feedContent ) ;
    	    scanner.useDelimiter(SPACE);
    	    
    	    while ( scanner.hasNext() ) {
    	    	String word = scanner.next();
    	    	if ( !excludeWordsSet.contains( word ) ) {
    	    		if ( map.containsKey( word ) ) {
    	    			int count = map.get( word );
    	    	    	count++;
    	    	    	map.put( word, count ) ;
    	    	    } else {
    	    	    	 map.put( word, 1 ) ;
    	    	    }
    	    	}  
    	    }
    	    scanner.close() ;
    	    return map ;
	}
	
	/**
	 * Return a map sorted by value, which is an integer
	 */
	public Map<String,Integer> sortMapByValue( Map<String,Integer> map ) {
		ValueComparator comparator =  new ValueComparator(map);
		Map<String,Integer> sortedMap = new TreeMap<String,Integer>(comparator);
    	sortedMap.putAll(map);
    	return sortedMap;
	}

	/**
	 * Print Map<String, Integer>
	 */
	public void printMap(Map<String,Integer> map) {
		System.out.println("results");
    	    for (String key : map.keySet()) {
    	    	    System.out.println("key value: " + key + " "+map.get(key));
    	    }
	}

	/**
	 * Main
	 */
    public static void main(String[] args)  {
    	    
    	ReadWebPageV2 readWebPage = new ReadWebPageV2() ;

    	try {		
    		// read feed content
    		StringBuilder feedInfo = readWebPage.readHttpToString( "http://blog.covestor.com/feed/atom" ) ;
    		String feedContent = readWebPage.extractContent( feedInfo ) ;
    	    
    		// read feed content 
    		StringBuilder excludeInfo = readWebPage.readHttpToString( "http://www.textfixer.com/resources/common-english-words.txt" ) ;
    		Set<String> excludeWordsSet = readWebPage.getExcludedWordsSet( excludeInfo.toString() ) ; 
    	    
    		// get Map with word count, excluding those excluded words.
    		Map<String,Integer> map = readWebPage.getWordCountMap( feedContent, excludeWordsSet ) ;
    		Map<String,Integer> sortedMap = readWebPage.sortMapByValue( map ) ;
    		readWebPage.printMap( sortedMap ) ;
    		} catch ( IOException ioe ) {
    			System.out.println( ioe ) ;
    		}
    }

}


/**
 * Comparator, comparing integer value.
 */
class ValueComparator implements Comparator<String>  {
	Map base;
	public ValueComparator(Map base) {
		this.base = base;
	}
	public int compare(String a, String b) {
		// comparing value, which is an integer.
		if((Integer)base.get(a) < (Integer)base.get(b)) {
			return 1;
		} else if((Integer)base.get(a) == (Integer)base.get(b)) {
			return 0;
		} else {
			return -1;
		}
	}
}
