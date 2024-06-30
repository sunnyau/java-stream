package exercise;

import java.util.concurrent.*;

class Share extends Thread{
  //static String msg[]={"A", "B", "C", "D", "E"};
  Share(String threadname){
  super(threadname);
  }
  public void run(){
  display(getName());
  }
  
  public synchronized void display(String threadN){
  //public void display(String threadN){
  	  System.out.println(threadN+"A");
  	    	    try{  this.sleep(1000);  }catch(Exception e){}
    	  System.out.println(threadN+" B");
    	    	    try{  this.sleep(1000);  }catch(Exception e){}
  	  System.out.println(threadN+"  C");
  	    	    try{  this.sleep(1000);  }catch(Exception e){}
  	  System.out.println(threadN+"   D");
  	    	    try{  this.sleep(1000);  }catch(Exception e){}
  	  System.out.println(threadN+"    E");    	  
  	    	    try{  this.sleep(1000);  }catch(Exception e){}
  }
}
public class SynchronizedThreadExample {
  public static void main(String[] args) {
  	  
//  	  ExecutorService es = Executors.newFixedThreadPool(1);
//  	  es.execute(new Share("Thread 1: "));
//  	  es.execute(new Share("Thread 2: "));  
//  	  es.execute(new Share("Thread 3: "));
//  	  es.execute(new Share("Thread 4: "));  
//  	  es.execute(new Share("Thread 5: "));
//  	  es.execute(new Share("Thread 6: "));  
//  	  es.execute(new Share("Thread 7: "));
//  	  es.execute(new Share("Thread 8: "));  
//  	  es.execute(new Share("Thread 9: "));  
//  	  es.shutdown();
  	    Share t1=new Share("Thread 1: ");
  	    t1.start();
  	    Share t2=new Share("Thread 2: ");
  	    t2.start();
  	    Share t3=new Share("Thread 3: ");
  	    t3.start();
  	    Share t4=new Share("Thread 4: ");
  	    t4.start();
  	    Share t5=new Share("Thread 5: ");
  	    t5.start();
  	    Share t6=new Share("Thread 6: ");
  	    t6.start();
  	    Share t7=new Share("Thread 7: ");
  	    t7.start();
  	    Share t8=new Share("Thread 8: ");
  	    t8.start();
  	    Share t9=new Share("Thread 9: ");
  	    t9.start();
  }
}
