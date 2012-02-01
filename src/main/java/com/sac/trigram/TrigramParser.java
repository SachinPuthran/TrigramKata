/**
 * 
 */
package com.sac.trigram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sachin Puthran
 *
 */
public class TrigramParser {

	public Map<String, List<String>> parse(String sentence) {

		Map<String, List<String>> trigramMap = new HashMap<String, List<String>>();

		if(sentence != null) {
			List<String> trigrams = getTrigrams(sentence);
			List<String> value;

			for (String trigram : trigrams) {
				String[] words = trigram.split(" ");
				String key = words[0] + " " + words[1];

				value = trigramMap.get(key);
				if(value == null) {
					value = new ArrayList<String>();
				}
				value.add(words[2]);
				trigramMap.put(key, value);
			}
		}
		
		return trigramMap;
	}

	private List<String> getTrigrams(String sentence) {
		List<String> trigrams = new ArrayList<String>();
		String[] words = sentence.split(" ");
		StringBuilder sb;
		for (int i = 0; i < words.length - 2; i++) {
			sb = new StringBuilder();
			sb.append(words[i]);
			sb.append(" ");
			sb.append(words[i+1]);
			sb.append(" ");
			sb.append(words[i+2]);
			trigrams.add(sb.toString());
		}
		return trigrams;
	}

}
