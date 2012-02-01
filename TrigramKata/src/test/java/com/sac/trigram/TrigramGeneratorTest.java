/**
 * 
 */
package com.sac.trigram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author Sachin Puthran
 *
 */
public class TrigramGeneratorTest {

	@Test
	public void generateNothing() {
		TrigramGenerator generator = new TrigramGenerator();
		assertNull(generator.generate(null, null));
	}

	@Test
	public void generateIMayI() {
		Map<String, List<String>> trigramMap = new HashMap<String, List<String>>();
		List<String> values = new ArrayList<String>();
		values.add("I");
		trigramMap.put("I may", values);
		
		TrigramGenerator generator = new TrigramGenerator();
		assertEquals("I may I", generator.generate(trigramMap, "I may"));
	}

	@Test
	public void generateIWishI() {
		Map<String, List<String>> trigramMap = new HashMap<String, List<String>>();
		List<String> values = new ArrayList<String>();
		values.add("I");
		trigramMap.put("I wish", values);
		
		TrigramGenerator generator = new TrigramGenerator();
		assertEquals("I wish I", generator.generate(trigramMap, "I wish"));
	}

	@Test
	public void generateIWishIMay() {
		Map<String, List<String>> trigramMap = new HashMap<String, List<String>>();
		List<String> values = new ArrayList<String>();
		values.add("I");
		trigramMap.put("I wish", values);
		values = new ArrayList<String>();
		values.add("may");
		trigramMap.put("wish I", values);
		
		TrigramGenerator generator = new TrigramGenerator();
		assertEquals("I wish I may", generator.generate(trigramMap, "I wish"));
	}

	 /* 'I wish' -> ['I', 'I']
	 * 'wish I' -> ['may', 'might']
	 * 'may I'  -> ['wish']
	 * 'I may'  -> ['I'] 
*/
	@Test
	public void generateIWishIMayIwishIMight() {
		Map<String, List<String>> trigramMap = new HashMap<String, List<String>>();
		List<String> values = new ArrayList<String>();
		values.add("I");
		values.add("I");
		trigramMap.put("I wish", values);
		
		values = new ArrayList<String>();
		values.add("may");
		values.add("might");
		trigramMap.put("wish I", values);
		
		values = new ArrayList<String>();
		values.add("wish");
		trigramMap.put("may I", values);
		
		values = new ArrayList<String>();
		values.add("I");
		trigramMap.put("I may", values);
		
		TrigramGenerator generator = new TrigramGenerator();
		String generatedText = generator.generate(trigramMap, "I wish");
		assertTrue(generatedText.endsWith("I might"));
	}

}
