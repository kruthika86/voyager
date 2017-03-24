package com.solrSearch.util;

import java.util.Comparator;

public class MyJSONComparator implements Comparator<String>{

	@Override
    public int compare(String s1, String s2) {
        //to compare the string to sort
		return s1.compareTo(s2);
    }
	
}
