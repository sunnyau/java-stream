package exercise;

import java.util.*;
import java.util.concurrent.*;
	  
	public class ConcurrentHashMapExample {
	  
	    public static void main(String args[]){
         /* 	    	    
	        List<String> myList = new ArrayList<String>();
	  
	        myList.add("1");
	        myList.add("2");
	        myList.add("3");
	        myList.add("4");
	        myList.add("5");
	  
	        Iterator<String> it = myList.iterator();
	        while(it.hasNext()){
	            String value = it.next();
	            System.out.println("List Value:"+value);
	            //if(value.equals("3")) myList.remove(value);
	        }
	  */
	        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
	        //Map<String,String> myMap = new HashMap<String,String>();
	        myMap.put("1", "1");
	        myMap.put("2", "2");
	        myMap.put("3", "3");
	  
	        System.out.println("----- Iteration 1");
	        Iterator<String> it1 = myMap.keySet().iterator();	        
	        while(it1.hasNext()){
	            String key = it1.next();
	            System.out.println("Map Value:"+myMap.get(key));
	            if(key.equals("2")){
	                //myMap.put("1","4");
	                myMap.put("4", "4");
	            }
	        }
	        System.out.println("----- Iteration 2");
	        it1 = myMap.keySet().iterator();
	        while(it1.hasNext()){
	            String key = it1.next();
	            System.out.println("Map Value:"+myMap.get(key));
	        }
	  
	    }
	}
