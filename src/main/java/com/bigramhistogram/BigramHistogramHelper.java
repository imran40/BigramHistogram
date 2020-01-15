package com.bigramhistogram;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BigramHistogramHelper {

    @Autowired
    private BigramHistogramBean bigramHistogramBean;
    
    /** This method is used to compute a Bigram Histogram
    *
    * @param  sentence The sentence that would be used as a data for Bigram Histogram
    * @return BigramHistogramBean This bean contains a map that stores the count of Bigram in the sentence. Bigram phrase is the key for this map.
    * 		  It also contains a list of Bigrams that are inserted in the list in the order of appearance in the sentence.
    */
	public BigramHistogramBean computeBigramHistogram(String sentence) {

		String[] splitSentence = sentence.split(" ");

		StringBuilder bigram = null;
		Map<String, Integer> bigramCountMap = new HashMap<String, Integer>();
		List<String> bigramList = new ArrayList<String>();

		for (int i = 0; i < (splitSentence.length - 1); i++) {
			bigram = new StringBuilder();
			bigram.append(splitSentence[i].toLowerCase()).append(" ").append(splitSentence[i + 1].toLowerCase());

			if (bigramCountMap.get(bigram.toString()) == null) {
				bigramCountMap.put(bigram.toString(), Integer.valueOf(1));
				bigramList.add(bigram.toString());
			} else if (bigramCountMap.get(bigram.toString()) != null) {
				bigramCountMap.put(bigram.toString(), Integer.valueOf(2));
			}
		}
		bigramHistogramBean.setBigramCountMap(bigramCountMap);
		bigramHistogramBean.setBigramList(bigramList);

		return bigramHistogramBean;
	}

    /** This method is used to Print a Bigram Histogram
    *
    * @param  BigramHistogramBean This bean contains a map that stores the count of Bigram in the sentence. Bigram phrase is the key for this map.
    * 		  It also contains a list of Bigrams that are inserted in the list in the order of appearance in the sentence.
    */
	public void printBigramHistogram(BigramHistogramBean bigramHistogramBean) {

		StringBuilder histogram = null;
		Map<String, Integer> bigramCountMap = bigramHistogramBean.getBigramCountMap();
		List<String> bigramList = bigramHistogramBean.getBigramList();

		for (int i = 0; i < bigramList.size(); i++) {
			histogram = new StringBuilder();
			System.out.println(histogram.append("\"").append(bigramList.get(i)).append("\"").append(" ").append(bigramCountMap.get(bigramList.get(i))));
		}
	}
	
    /** This method is used to load sentences from a text file
    *
    * @param  filePath This is the path of the file that holds the sentences used as a data to compute bigram histogram
    * @return This method returns a list of sentences that are loaded from the text file.
    */
	public List<String> loadSentences(String filePath) {
		List<String> senentences = null;
		try {
			senentences = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return senentences;
	}
}
