package com.bigramhistogram;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton") 
public class BigramHistogramBean {
	
	private Map<String, Integer> bigramCountMap = null;
	private List<String> bigramList = null;
	private String sentence = null;

	public Map<String, Integer> getBigramCountMap() {
		return bigramCountMap;
	}
	public void setBigramCountMap(Map<String, Integer> bigramCountMap) {
		this.bigramCountMap = bigramCountMap;
	}
	public List<String> getBigramList() {
		return bigramList;
	}
	public void setBigramList(List<String> bigramList) {
		this.bigramList = bigramList;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

}
