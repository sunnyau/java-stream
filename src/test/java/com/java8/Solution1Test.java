
package com.java8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class Solution1Test
{

    @Test
    public void test()
    {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        Solution1 solution1 = new Solution1();
        List<List<String>> returnList = solution1.groupAnagrams( strs );
        System.out.println(returnList);

        List<List<String>> expected = List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat"));

        // expected = [[eat, tea, ate], [bat], [tan, nat]]

        // assertEquals(true, true);
        assertEquals(expected, returnList);

    }

}
