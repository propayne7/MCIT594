package Assignment3;

import java.util.HashSet;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateScoresTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSingleWord() {
        Word word = new Word("apple");
        word.increaseTotal(2);
        word.increaseTotal(1);
        HashSet<Word> hashSet = new HashSet<Word>();
        hashSet.add(word);
        Map map = null;
        try {
            map = Analyzer.calculateScores(hashSet);
        }
        catch (Exception exception) {
            Assert.fail((String)("calculateScores throws exception when input has a single Word: " + exception.toString()));
        }
        if (map == null) {
            Assert.fail((String)"calculateScores returns incorrect value when input has a single Word");
        } else if (map.isEmpty()) {
            Assert.fail((String)"calculateScores returns incorrect value when input has a single Word");
        }
        Assert.assertTrue((String)"calculateScores has wrong number of elements when input has a single Word", (boolean)(1 == map.size()));
        Assert.assertTrue((String)"calculateScores has wrong key for element when input has a single Word", (boolean)map.containsKey("apple"));
        double d = (Double)map.get("apple");
        Assert.assertTrue((String)"calculateScores has wrong score value for element when input has a single Word", (boolean)(Math.abs(1.5 - d) <= 1.0E-5));
    }

    @Test
    public void testMultipleWords() {
        Word word = new Word("apple");
        word.increaseTotal(2);
        word.increaseTotal(1);
        Word word2 = new Word("banana");
        word2.increaseTotal(1);
        HashSet<Word> hashSet = new HashSet<Word>();
        hashSet.add(word);
        hashSet.add(word2);
        Map map = null;
        try {
            map = Analyzer.calculateScores(hashSet);
        }
        catch (Exception exception) {
            Assert.fail((String)("calculateScores throws exception when input has multiple Words: " + exception.toString()));
        }
        if (map == null) {
            Assert.fail((String)"calculateScores returns incorrect value when input has multiple Words");
        } else if (map.isEmpty()) {
            Assert.fail((String)"calculateScores returns incorrect value when input has multiple Words");
        }
        Assert.assertTrue((String)"calculateScores has wrong number of elements when input has multiple Words", (boolean)(2 == map.size()));
        Assert.assertTrue((String)"calculateScores has wrong key for element when input has multiple Words", (boolean)map.containsKey("apple"));
        Assert.assertTrue((String)"calculateScores has wrong key for element when input has multiple Words", (boolean)map.containsKey("banana"));
        double d = (Double)map.get("apple");
        Assert.assertTrue((String)"calculateScores has wrong score value for element when input has multiple Words", (boolean)(Math.abs(1.5 - d) <= 1.0E-5));
        d = (Double)map.get("banana");
        Assert.assertTrue((String)"calculateScores has wrong score value for element when input has multiple Words", (boolean)(1.0 == d));
    }
}