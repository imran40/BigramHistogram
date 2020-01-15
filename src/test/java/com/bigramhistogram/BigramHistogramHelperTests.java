package com.bigramhistogram;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BigramHistogramHelperTests  extends BigramHistogramApplicationTests{

    @Autowired
    private BigramHistogramHelper bigramHistogramHelper;

	@Test
	public void testComputeBigramHistogram() throws Exception {
		
		String testBigramString = "the quick";
		int testBigramCount = 2;
		int testBigramListSize = 7;
		boolean isTestSuccessful = false;
		
		String sentence = "The quick brown fox and the quick blue hare";
		BigramHistogramBean bigramHistogramBean = bigramHistogramHelper.computeBigramHistogram(sentence);
		
		Map<String, Integer> bigramCountMap = bigramHistogramBean.getBigramCountMap();
		List<String> bigramList = bigramHistogramBean.getBigramList();
		
		if((bigramCountMap.get(testBigramString) == testBigramCount) && bigramList.size() == testBigramListSize) {
			isTestSuccessful = true;
		}
		
		assertTrue(isTestSuccessful);

	}
	
	@Test
	public void loadSentences() throws Exception {
		int testSentencesCount = 6;
		boolean isTestSuccessful = false;
		
		String filePath = System.getProperty("user.dir") + "\\TestFiles\\Sentences.txt";
		List<String> senentences = bigramHistogramHelper.loadSentences(filePath);
		
		if(senentences.size() == testSentencesCount) {
			isTestSuccessful = true;
		}
		
		assertTrue(isTestSuccessful);
	}

}
