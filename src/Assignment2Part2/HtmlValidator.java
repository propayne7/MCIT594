package Assignment2Part2;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {
	
	/* 
	 * Implement this method!
	 */
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		// handling of null cases
		if(tags == null){ return null; }
		if(tags.isEmpty()){ return null; }

		// create a stack of open tag HTML elements from the tags queue (method argument)
		Stack<HtmlTag> htmlTagStack = new Stack<>();
		Stack<HtmlTag> openHtmlTagStack = new Stack<>();
		Queue<HtmlTag> closingTagQueue = new LinkedList<>();

		// populate a stack with all html tags
		for(HtmlTag z : tags){
			htmlTagStack.push(z);
		}

		// populate a stack of only open tags
		for(HtmlTag i : tags){
			if(i.isOpenTag() && !i.isSelfClosing()){
				openHtmlTagStack.push(i);
			}
		}

		// populate a queue of closing tags
		for(HtmlTag x1 : tags){
			if(x1.toString().contains("/") && !x1.isSelfClosing()){
				closingTagQueue.add(x1);
			}
		}

		// compare the order of opening and closing tags
		boolean control = true;
		while(control){
			if(openHtmlTagStack.isEmpty()){ break; }

			HtmlTag stackValue = openHtmlTagStack.peek();
			HtmlTag queueValue = closingTagQueue.peek();

			System.out.println("Comparing: " + stackValue + " to " + queueValue);

			if(stackValue.matches(queueValue)){
				System.out.println("Stack value: " + stackValue + " matches Queue value: " + queueValue);
				openHtmlTagStack.pop();
				closingTagQueue.poll();
			} else {
				control = false;
			}
		}

		if(openHtmlTagStack.isEmpty() && !closingTagQueue.isEmpty()){
			return null;
		}
		return openHtmlTagStack; // change as needed!
	}
	
	/*
	 * Instructor-provided code:
	 * This function reads an HTML file and outputs its structure as the HtmlTags only.
	 * You do not need to modify this code for this assignment but can use it for your testing!
	 */
	public static Queue<HtmlTag> getTagsFromHtmlFile(String filename) throws IOException {
	     InputStream stream = new FileInputStream(filename);
	     StringBuffer buffer = new StringBuffer();
	     int ch;
	     while ((ch = stream.read()) > 0) {
	         buffer.append((char) ch);
	     }
	     stream.close();
	     String htmlFileString = buffer.toString();
	     return HtmlTag.tokenize(htmlFileString);
	}

}

