/**
 * 
 */
package com.sac.trigram;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Sachin Puthran
 *
 */
public class TrigramGenerator {

	public String generate(Map<String, List<String>> trigramMap, String seed) {
		if(trigramMap == null || seed == null) {
			return null;
		}
		
		StringBuilder generatedText = new StringBuilder(seed);
		List<String> values;
		Random rand = new Random();
		while((values = trigramMap.get(seed)) != null) {
			String val;
			int size = values.size();
			if(size > 1) {
				val = values.get(Math.abs(rand.nextInt())%size);
			} else {
				val = values.get(0);
			}
			seed = seed.split(" ")[1] + " " + val;
			generatedText.append(" ").append(val);
		}
		return generatedText.toString();
		
	}
}
