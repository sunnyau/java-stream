package com.java8;

import java.util.List;
import java.util.Map;
import java.util.*;

// JP Morgan inteview question
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

class Solution1 {

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        Solution1 solution = new Solution1();
        List<List<String>> returnList = solution.groupAnagrams( strs );

        System.out.println(returnList);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // key is the sorted string. value is the strings.
        Map<String,List<String>> map = new HashMap<>();

        for ( String s : strs ) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            // listchar is in alphabetical order.
            if ( !map.containsKey(sorted)  ) {
                List<String> listOfString = new LinkedList<>();
                listOfString.add(s);
                map.put(sorted,listOfString);
            } else {
                List<String> listOfString = map.get(sorted);
                listOfString.add(s);                
            }
        }

        List<List<String>> returnList = new LinkedList<>();

        for ( List<String> values : map.values() ) {
            // String key = kv.getKey();
            // List<String> values = kv.get(key);
            returnList.add(values);
            // System.out.println(key);
            // System.out.println(values);
        }

        return returnList;
    }

}

