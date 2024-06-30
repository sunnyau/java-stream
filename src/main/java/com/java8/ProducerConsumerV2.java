package com.java8;


/**
 * Not sure if it is correct.
 */
import java.util.LinkedList;
import java.util.Date;

public class ProducerConsumerV2 {

	public LinkedList<Object> list = new LinkedList<Object>();

	public ProducerConsumerV2( int noOfProducer, int noOfConsumer ) throws Exception {
		for ( int i = 0 ; i < noOfProducer ; i++ ) {
			new Producer().start() ;
			Thread.sleep(1000);
		}
		for ( int i = 0 ; i < noOfConsumer ; i++ ) {
			new Consumer().start() ;
			Thread.sleep(1000);
		}
	}

	public static void main( String[] args ) throws Exception {
		new ProducerConsumerV2( 3, 2 );

		while ( true ) {
			Thread.sleep(1000);
		}
	}


	class Producer extends Thread {
		public Producer() {}
		public void run() {
			while ( true ) {
			Date date = new Date();
			list.add( date ) ;
			System.out.println( "Added " + date.toString() ) ;
			}
		}
	}
	class Consumer extends Thread {
		public Consumer() {}
		public void run() {
			while ( true ) {
			list.removeLast();
			System.out.println( "Removed ");
			}
		}
	}
}