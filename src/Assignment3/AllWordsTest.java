package Assignment3;

import Assignment3.Analyzer;
import Assignment3.Sentence;
import Assignment3.Word;
import org.junit.Test;
import java.util.Set;
import org.junit.Assert;
import java.util.List;
import java.util.LinkedList;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class AllWordsTest
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAllWordsDistinct() {
        final Sentence sentence = new Sentence(0, "word dog ");
        final Sentence sentence2 = new Sentence(0, "cat monkey ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        Set allWords = null;
        try {
            allWords = Analyzer.allWords((List)list);
        }
        catch (Exception ex) {
            Assert.fail("allWords throws exception when all words in input are distinct: " + ex.toString());
        }
        if (allWords == null) {
            Assert.fail("allWords returns incorrect value when all words in List are distinct");
        }
        else if (allWords.isEmpty()) {
            Assert.fail("allWords returns incorrect value when all words in List are distinct");
        }
        Assert.assertEquals("allWords contains incorrect number of elements when all words are distinct", 4L, (long)allWords.size());
        final Word word = new Word("word");
        word.increaseTotal(0);
        final Word word2 = new Word("dog");
        word2.increaseTotal(0);
        final Word word3 = new Word("cat");
        word3.increaseTotal(0);
        final Word word4 = new Word("monkey");
        word4.increaseTotal(0);
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word2));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word3));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word4));
    }

    @Test
    public void testCorrectTotalAllWordsDistinctScoresPositive() {
        final Sentence sentence = new Sentence(1, "word dog ");
        final Sentence sentence2 = new Sentence(2, "cat monkey ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        Set allWords = null;
        try {
            allWords = Analyzer.allWords((List)list);
        }
        catch (Exception ex) {
            Assert.fail("allWords throws exception when all words in input are distinct: " + ex.toString());
        }
        if (allWords == null) {
            Assert.fail("allWords returns incorrect value when all words are distinct");
        }
        else if (allWords.isEmpty()) {
            Assert.fail("allWords returns incorrect value when all words are distinct");
        }
        Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == allWords.size());
        final Word word = new Word("word");
        word.increaseTotal(1);
        final Word word2 = new Word("dog");
        word2.increaseTotal(1);
        final Word word3 = new Word("cat");
        word3.increaseTotal(2);
        final Word word4 = new Word("monkey");
        word4.increaseTotal(2);
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word2));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word3));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word4));
    }

    @Test
    public void testCorrectTotalAllWordsDistinctScoresNegative() {
        final Sentence sentence = new Sentence(-1, "word dog ");
        final Sentence sentence2 = new Sentence(-2, "cat monkey ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        Set allWords = null;
        try {
            allWords = Analyzer.allWords((List)list);
        }
        catch (Exception ex) {
            Assert.fail("allWords throws exception when all words in input are distinct: " + ex.toString());
        }
        if (allWords == null) {
            Assert.fail("allWords returns incorrect value when all words are distinct");
        }
        else if (allWords.isEmpty()) {
            Assert.fail("allWords returns incorrect value when all words are distinct");
        }
        Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == allWords.size());
        final Word word = new Word("word");
        word.increaseTotal(-1);
        final Word word2 = new Word("dog");
        word2.increaseTotal(-1);
        final Word word3 = new Word("cat");
        word3.increaseTotal(-2);
        final Word word4 = new Word("monkey");
        word4.increaseTotal(-2);
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word2));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word3));
        Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word4));
    }

    @Test
    public void testSomeWordsAppearMoreThanOnce() {
        final Sentence sentence = new Sentence(0, "word dog ");
        final Sentence sentence2 = new Sentence(0, "cat dog ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        Set allWords = null;
        try {
            allWords = Analyzer.allWords((List)list);
        }
        catch (Exception ex) {
            Assert.fail("allWords throws exception when some words appear more than once: " + ex.toString());
        }
        if (allWords == null) {
            Assert.fail("allWords returns incorrect value when some words appear more than once");
        }
        else if (allWords.isEmpty()) {
            Assert.fail("allWords returns incorrect value when some words appear more than once");
        }
        Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == allWords.size());
        final Word word = new Word("word");
        word.increaseTotal(0);
        final Word word2 = new Word("dog");
        word2.increaseTotal(0);
        final Word word3 = new Word("cat");
        word3.increaseTotal(0);
        word2.increaseTotal(0);
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", allWords.contains(word));
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", allWords.contains(word2));
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", allWords.contains(word3));
    }

    @Test
    public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresPositive() {
        final Sentence sentence = new Sentence(1, "word dog ");
        final Sentence sentence2 = new Sentence(2, "cat dog ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        Set allWords = null;
        try {
            allWords = Analyzer.allWords((List)list);
        }
        catch (Exception ex) {
            Assert.fail("allWords throws exception when some words appear more than once: " + ex.toString());
        }
        if (allWords == null) {
            Assert.fail("allWords returns incorrect value when some words appear more than once");
        }
        else if (allWords.isEmpty()) {
            Assert.fail("allWords returns incorrect value when some words appear more than once");
        }
        Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == allWords.size());
        final Word word = new Word("word");
        word.increaseTotal(1);
        final Word word2 = new Word("dog");
        word2.increaseTotal(1);
        final Word word3 = new Word("cat");
        word3.increaseTotal(2);
        word2.increaseTotal(2);
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", allWords.contains(word));
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", allWords.contains(word2));
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", allWords.contains(word3));
    }

    @Test
    public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresNegative() {
        final Sentence sentence = new Sentence(-1, "word dog ");
        final Sentence sentence2 = new Sentence(-2, "cat dog ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        Set allWords = null;
        try {
            allWords = Analyzer.allWords((List)list);
        }
        catch (Exception ex) {
            Assert.fail("allWords throws exception when some words appear more than once: " + ex.toString());
        }
        if (allWords == null) {
            Assert.fail("allWords returns incorrect value when some words appear more than once");
        }
        else if (allWords.isEmpty()) {
            Assert.fail("allWords returns incorrect value when some words appear more than once");
        }
        Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == allWords.size());
        final Word word = new Word("word");
        word.increaseTotal(-1);
        final Word word2 = new Word("dog");
        word2.increaseTotal(-1);
        final Word word3 = new Word("cat");
        word3.increaseTotal(-2);
        word2.increaseTotal(-2);
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", allWords.contains(word));
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", allWords.contains(word2));
        Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", allWords.contains(word3));
    }
}