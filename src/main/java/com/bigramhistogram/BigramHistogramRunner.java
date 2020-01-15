package com.bigramhistogram;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BigramHistogramRunner  implements CommandLineRunner {
	//private static final Logger logger = LoggerFactory.getLogger(BigramHistogramRunner.class);

    @Autowired
    private BigramHistogramHelper bigramHistogramHelper;

    @Override
    public void run(String... args) {
		String filePath = System.getProperty("user.dir") + "\\TestFiles\\Sentences.txt";
		BigramHistogramBean bigramHistogramBean = null;
		
		List<String> sentences = bigramHistogramHelper.loadSentences(filePath);
		
		for(int i=0; i < sentences.size(); i++) {
			System.out.println("Senetence:");
			System.out.println(sentences.get(i));
			System.out.println("Histogram:");
			bigramHistogramBean = bigramHistogramHelper.computeBigramHistogram(sentences.get(i));
			bigramHistogramHelper.printBigramHistogram(bigramHistogramBean);
			System.out.println("\n=========================================================================================\n");
		}
    }
}
