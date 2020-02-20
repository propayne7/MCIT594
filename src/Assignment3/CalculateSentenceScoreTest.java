package Assignment3;

import org.junit.Test;
import org.junit.Assert;
import java.util.Map;
import java.util.HashMap;
import org.junit.Before;

//
// Decompiled by Procyon v0.5.36
//

public class CalculateSentenceScoreTest
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAllWordsInSentenceAndScoresAreInts() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        hashMap.put("cat", 2.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have integer scores", 2.0 == Analyzer.calculateSentenceScore((Map)hashMap, "dog cat"));
        }
        catch (Exception ex) {
            Assert.fail("calculateSentenceScore throws exception when all words in Map are in sentence and have integer scores: " + ex.toString());
        }
    }

    @Test
    public void testAllWordsInSentenceAndScoresAreDoubles() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 1.7);
        hashMap.put("cat", 1.9);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have floating-point scores", Math.abs(1.8 - Analyzer.calculateSentenceScore((Map)hashMap, "dog cat")) < 1.0E-6);
        }
        catch (Exception ex) {
            Assert.fail("calculateSentenceScore throws exception when all words in Map are in sentence and have floating-point scores: " + ex.toString());
        }
    }

    @Test
    public void testSomeWordsNotInMap() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        hashMap.put("cat", 1.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when some words in sentence are not in input Map", 1.0 == Analyzer.calculateSentenceScore((Map)hashMap, "dog cat gorilla"));
        }
        catch (Exception ex) {
            Assert.fail("calculateSentenceScore throws exception when some words in sentence are not in input Map: " + ex.toString());
        }
    }
}
