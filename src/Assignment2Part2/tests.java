package Assignment2Part2;

import org.junit.Test;
import org.junit.Assert;
import java.util.Queue;
import java.util.Stack;


public class tests
{
    private Stack<HtmlTag> validateTestFile(final String str) {
        Queue tagsFromHtmlFile = null;
        try {
            tagsFromHtmlFile = HtmlValidator.getTagsFromHtmlFile("str");
        }
        catch (Exception ex) {
            Assert.fail("An unexpected error occurred while attempting to read the input file " + str + "; be sure it is in the directory along with your source code: " + ex.toString());
        }
        try {
            return (Stack<HtmlTag>)HtmlValidator.isValidHtml(tagsFromHtmlFile);
        }
        catch (Exception ex2) {
            Assert.fail("isValidHtml threw exception: " + ex2.toString());
            return null;
        }
    }

    @Test
    public void testFile1() {
        Assert.assertTrue("isValidHtml returns incorrect value for a valid HTML file (test1.html)", this.validateTestFile("C:\\Users\\cpayne002\\Desktop\\MCIT\\MCIT594\\src\\Assignment2Part2\\test1.html").isEmpty());
    }

    @Test
    public void testFile2() {
        final Stack<HtmlTag> validateTestFile = this.validateTestFile("C:\\Users\\cpayne002\\Desktop\\MCIT\\MCIT594\\src\\Assignment2Part2\\test2.html");
        final Stack<HtmlTag> stack = new Stack<HtmlTag>();
        stack.push(new HtmlTag("html", true));
        stack.push(new HtmlTag("b", true));
        Assert.assertTrue("isValidHtml returns incorrect value when input file ends without closing tags (test2.html)", stack.equals(validateTestFile));
    }

    @Test
    public void testFile3() {
        final Stack<HtmlTag> validateTestFile = this.validateTestFile("C:\\Users\\cpayne002\\Desktop\\MCIT\\MCIT594\\src\\Assignment2Part2\\test3.html");
        final Stack<HtmlTag> stack = new Stack<HtmlTag>();
        stack.push(new HtmlTag("b", true));
        stack.push(new HtmlTag("i", true));
        Assert.assertTrue("isValidHtml returns incorrect value when tags are closed in incorrect order (test3.html)", stack.equals(validateTestFile));
    }
}