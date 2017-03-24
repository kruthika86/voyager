package com.solrSearch.util;

import java.util.List;

public interface SOLRSearch {

	public List<String> getResults(String criteria, List<String> displayFields);
}
