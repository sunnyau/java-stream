package exercise;

/**
 * try catch finally
 */
public class TryCatchFinally 
{
    public static void main( String[] args )
    {
    	try {
    		System.out.println( "try" );
    		System.exit(0);
    		// finally won't be called after running System.exit.
    	} catch ( Exception e ) {
    		System.out.println( "catch" );
    	} finally {
    		System.out.println( "finally" );
    	}
        
    }
}
