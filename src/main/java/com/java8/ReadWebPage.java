package exercise;

import java.net.*;
import java.io.*;
import java.lang.* ;
import java.util.* ;

// Submitted by : Sunny Au

public class ReadWebPage {
	
	public static final String OPEN_CONTENT = "<content" ;
	public static final String CLOSE_CONTENT = "</content>" ;
	public static final String SPACE = " ";
	
	// construtor 		
	public ReadWebPage() {} ;
	
	public StringBuilder readAtomFeedsToStringBuilder( String httpFeeds ) throws Exception {
        	URL oracle = new URL(httpFeeds);
        	URLConnection yc = oracle.openConnection();
        	BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                // to put all readLine content into StringBuilder
                StringBuilder stringBuilder = new StringBuilder() ;
                
                while ((inputLine = in.readLine()) != null) {
                	stringBuilder.append(inputLine);                
                }
                in.close();
                
                return stringBuilder ;
	}
	
	public String extractContent( StringBuilder stringBuilder ) {
		int openContentIndex = 0 ;
                int closeContentIndex = 0 ;
                
                StringBuilder returnString = new StringBuilder() ;
                
                while ( openContentIndex != -1 ) {
                
                	//System.out.println("stringBuilder.length()" + stringBuilder.length() ) ;
                	
                	openContentIndex = stringBuilder.indexOf(OPEN_CONTENT);
                	closeContentIndex = stringBuilder.indexOf(CLOSE_CONTENT);
                	
                	//System.out.println("openContentIndex" + openContentIndex );
                	//System.out.println("closeContentIndex" + closeContentIndex ) ;
                	
                	// cut out the content information, including those before the content and search again.    
                	if ( openContentIndex != -1 && closeContentIndex != -1 ) {
                		returnString.append( stringBuilder.substring( openContentIndex, closeContentIndex ) ) ;
                		//System.out.println("================" ) ;
                		stringBuilder = stringBuilder.delete( 0, closeContentIndex + CLOSE_CONTENT.length()  ) ;
                	}
                	
                }
                return returnString.toString() ;
	}
	
    public static void main(String[] args) throws Exception {
    	    
    	    ReadWebPage readWebPage = new ReadWebPage() ;
    	    
    	    // read feed content
    	    StringBuilder feedInfo = readWebPage.readAtomFeedsToStringBuilder( "http://blog.covestor.com/feed/atom" ) ;
    	    String feedContent = readWebPage.extractContent( feedInfo ) ;
    	    
    	    //System.out.println( feedContent ) ;
    	    
    	    // read exclude words
    	    StringBuilder excludeInfo = readWebPage.readAtomFeedsToStringBuilder( "http://www.textfixer.com/resources/common-english-words.txt" ) ;
    	    String[] excludeWords = excludeInfo.toString().split(",") ;
    	    
    	    
    	    // Use Scanner to exclude words from feedContent 
    	    // exclude words are delimiter
    	    /* DIDN'T WORK
    	    
    	    //String excludeWordsWithComma = excludeInfo.toString().replace(","," ");
    	    Scanner scanner = new Scanner(feedContent) ; 
    	    scanner.useDelimiter(excludeWordsWithComma);
    	    
    	    while ( scanner.hasNext() ) {
    	    	      System.out.println(scanner.next());
    	    	      
    	    }   	   
    	    scanner.close() ;
    	    */
    	    
    	    // replace excludeWords by space in feedContent 
    	    // Not the best method. But it works
    	    for ( String excludeWord : excludeWords ) {    	    	    
    	    	    feedContent = feedContent.replace( SPACE + excludeWord + SPACE, SPACE ) ;
    	    }
    	    
    	    System.out.println( feedContent ) ;
    	        	    
    	    // count the most appearing word
    	    // use HashMap. key is the word and value is the count
    	    
    	    Map map = new HashMap() ;
    	    
    	    // cannot finish it.
    	    
    	    
        
    }
}
