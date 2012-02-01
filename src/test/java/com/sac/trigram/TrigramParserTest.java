/**
 * 
 */
package com.sac.trigram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author Sachin Puthran
 *
 */
public class TrigramParserTest {

	@Test
	public void parseNull() {
		TrigramParser parser = new TrigramParser();
		assertEquals(0, parser.parse(null).size());
	}
	
	/**
	 * Parse "I may I" Trigram and return first "I may" as key and "I" as the value.
	 */
	@Test
	public void parseIMayITrigram() {
		TrigramParser parser = new TrigramParser();
		Map<String, List<String>> trigrams = parser.parse("I may I");
		
		assertEquals(1, trigrams.size());
		assertEquals(1, trigrams.get("I may").size());
		assertTrue(trigrams.get("I may").contains("I"));
	}

	/**
	 * Parse "I wish I" Trigram and return first "I wish" as key and "I" as the value.
	 */
	@Test
	public void parseIWishITrigram() {
		TrigramParser parser = new TrigramParser();
		Map<String, List<String>> trigrams = parser.parse("I wish I");
		
		assertEquals(1, trigrams.size());
		assertEquals(1, trigrams.get("I wish").size());
		assertTrue(trigrams.get("I wish").contains("I"));
	}

	/**
	 * Parse "I wish I may" Trigram and return 2 entries in the map 
	 * 'I wish' -> ['I']
	 * 'wish I' -> ['may']
	 */
	@Test
	public void parseIWishIMayTrigram() {
		TrigramParser parser = new TrigramParser();
		Map<String, List<String>> trigrams = parser.parse("I wish I may");
		
		assertEquals(2, trigrams.size());
		assertEquals(1, trigrams.get("I wish").size());
		assertTrue(trigrams.get("I wish").contains("I"));
		
		assertEquals(1, trigrams.get("wish I").size());
		assertTrue(trigrams.get("wish I").contains("may"));
	}

	/**
	 * Parse "I wish I may I wish I might" Trigram and return 4 entries in the map as below
	 * 'I wish' -> ['I', 'I'],
	 * 'wish I' -> ['may', 'might'],
	 * 'may I'  -> ['wish'],
	 * 'I may'  -> ['I'] 
	 */
	@Test
	public void parseIWishIMayIwishImightTrigram() {
		TrigramParser parser = new TrigramParser();
		Map<String, List<String>> trigrams = parser.parse("I wish I may I wish I might");
		
		assertEquals(4, trigrams.size());
		
		assertEquals(2, trigrams.get("I wish").size());
		assertTrue(trigrams.get("I wish").contains("I"));
		
		assertEquals(2, trigrams.get("wish I").size());
		assertTrue(trigrams.get("wish I").contains("may"));
		assertTrue(trigrams.get("wish I").contains("might"));

		assertEquals(1, trigrams.get("may I").size());
		assertTrue(trigrams.get("may I").contains("wish"));
		
		assertEquals(1, trigrams.get("I may").size());
		assertTrue(trigrams.get("I may").contains("I"));

	}
}
