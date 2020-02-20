package Assignment3;

import org.junit.Test;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;

//
// Decompiled by Procyon v0.5.36
//

public class ReadFileTest
{
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testTextOneSentence() {
        List<Sentence> file = null;
        try {
            file = (List<Sentence>)Analyzer.readFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment3\\test1.txt");
        }
        catch (Exception ex) {
            Assert.fail("readFile throws exception when processing file with one sentence (test1.txt): " + ex.toString());
        }
        if (file == null) {
            Assert.fail("readFile returns incorrect value when processing file with one sentence (test1.txt)");
        }
        if (file.isEmpty()) {
            Assert.fail("readFile returns incorrect value when processing file with one sentence (test1.txt)");
        }
        Assert.assertTrue("readFile return value contains wrong number of elements when file has one sentence (test1.txt)", 1 == file.size());
        final Sentence sentence = file.get(0);
        if (sentence == null) {
            Assert.fail("readFile return value contains null Sentence when file has one sentence (test1.txt)");
        }
        Assert.assertTrue("readFile return value contains Sentence with incorrect score when file has one sentence (test1.txt)", 0 == sentence.getScore());
        Assert.assertTrue("readFile return value contains Sentence with incorrect text when file has one sentence (test1.txt)", "this is a test".equals(sentence.getText()));
    }

    @Test
    public void testScoreOneSentence() {
        List<Sentence> file = null;
        try {
            file = (List<Sentence>)Analyzer.readFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment3\\test2.txt");
        }
        catch (Exception ex) {
            Assert.fail("readFile throws exception when processing file with one sentence (test2.txt): " + ex.toString());
        }
        if (file == null) {
            Assert.fail("readFile returns incorrect value when processing file with one sentence (test2.txt)");
        }
        if (file.isEmpty()) {
            Assert.fail("readFile returns incorrect value when processing file with one sentence (test2.txt)");
        }
        Assert.assertTrue("readFile contains wrong number of elements when file has one sentence (test2.txt)", 1 == file.size());
        final Sentence sentence = file.get(0);
        if (sentence == null) {
            Assert.fail("readFile return value contains null Sentence when file has one sentence (test2.txt)");
        }
        Assert.assertTrue("readFile return value contains Sentence with incorrect score when file has one sentence (test2.txt)", 2 == sentence.getScore());
        Assert.assertTrue("readFile return value contains Sentence with incorrect text when file has one sentence (test2.txt)", "this is a test".equals(sentence.getText()));
    }

    @Test
    public void testMultipleSentencesPositiveScores() {
        List<Sentence> file = null;
        try {
            file = (List<Sentence>)Analyzer.readFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment3\\test3.txt");
        }
        catch (Exception ex) {
            Assert.fail("readFile throws exception when processing file with multiple sentences (test3.txt): " + ex.toString());
        }
        if (file == null) {
            Assert.fail("readFile returns incorrect value when processing file with multiple sentences (test3.txt)");
        }
        if (file.isEmpty()) {
            Assert.fail("readFile returns incorrect value when processing file with multiple sentences (test3.txt)");
        }
        Assert.assertTrue("readFile return value contains wrong number of elements when file has multiple sentences (test3.txt)", 3 == file.size());
        final Sentence sentence = file.get(0);
        if (sentence == null) {
            Assert.fail("readFile return value contains null Sentence when file has multiple sentences (test3.txt)");
        }
        Assert.assertTrue("readFile return value contains Sentence with incorrect score when file has multiple sentences (test3.txt)", 0 == sentence.getScore());
        Assert.assertTrue("readFile return value contains Sentence with incorrect text when file has multiple sentences (test3.txt)", "this is a test".equals(sentence.getText()));
        final Sentence sentence2 = file.get(1);
        if (sentence2 == null) {
            Assert.fail("readFile return value contains null Sentence when file has multiple sentences (test3.txt)");
        }
        Assert.assertTrue("readFile return value contains Sentence with incorrect score when file has multiple sentences (test3.txt)", 1 == sentence2.getScore());
        Assert.assertTrue("readFile return value contains Sentence with incorrect text when file has multiple sentences (test3.txt)", "dogs are so cute".equals(sentence2.getText()));
        final Sentence sentence3 = file.get(2);
        if (sentence3 == null) {
            Assert.fail("readFile return value contains null Sentence when file has multiple sentences (test3.txt)");
        }
        Assert.assertTrue("readFile return value contains Sentence with incorrect score when file has multiple sentences (test3.txt)", 2 == sentence3.getScore());
        Assert.assertTrue("readFile return value contains Sentence with incorrect text when file has multiple sentences (test3.txt)", "testing is boring".equals(sentence3.getText()));
    }

    @Test
    public void testMultipleSentencesNegativeScores() {
        List<Sentence> file = null;
        try {
            file = (List<Sentence>)Analyzer.readFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment3\\test4.txt");
        }
        catch (Exception ex) {
            Assert.fail("readFile throws execption when processing file with multiple sentences (test4.txt): " + ex.toString());
        }
        if (file == null) {
            Assert.fail("readFile returns incorrect value when processing file with multiple sentences (test4.txt)");
        }
        if (file.isEmpty()) {
            Assert.fail("readFile returns incorrect value when processing file with multiple sentences (test4.txt)");
        }
        Assert.assertTrue("readFile return value contains wrong number of elements when file has multiple sentences (test4.txt)", 3 == file.size());
        final Sentence sentence = file.get(1);
        if (sentence == null) {
            Assert.fail("readFile return value contains null Sentence when file has multiple sentences (test4.txt)");
        }
        Assert.assertTrue("readFile return value contains Sentence with incorrect score when file has multiple sentences and score is negative (test4.txt)", -1 == sentence.getScore());
        Assert.assertTrue("readFile return value contains Sentence with incorrect text when file has multiple sentences and score is negative (test4.txt)", "dogs are so cute".equals(sentence.getText()));
        final Sentence sentence2 = file.get(2);
        if (sentence2 == null) {
            Assert.fail("readFile return value contains null Sentence when file has multiple sentences (test4.txt)");
        }
        Assert.assertTrue("readFile return value contains Sentence with incorrect score when file has multiple sentences and score is negative (test4.txt)", -2 == sentence2.getScore());
        Assert.assertTrue("readFile return value contains Sentence with incorrect text when file has multiple sentences and score is negative (test4.txt)", "testing is boring".equals(sentence2.getText()));
    }
}