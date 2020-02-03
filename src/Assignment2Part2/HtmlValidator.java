package Assignment2Part2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;

public class HtmlValidator {
	
	/* 
	 * Implement this method!
	 */
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		// check if queue passed to the method is null or empty
		if(tags == null){ return null; }
		if(tags.isEmpty()){ return null; }

		// create a queue of closing tags
		Queue<HtmlTag> closingTagsQueue = getClosingTags(tags);
		Queue<HtmlTag> excludeSelfClosing = cleanseClosingTags(tags);

		Stack<HtmlTag> stackTags = new Stack<>();


		for(HtmlTag t : excludeSelfClosing){
			if(!t.toString().contains("/")){
				stackTags.push(t);
			} else if(t.toString().contains("/") && t.matches(stackTags.peek())){
				stackTags.pop();
				closingTagsQueue.remove(t);
			}
			else if(t.toString().contains("/") && !t.matches(stackTags.peek())){
				break;

			}
			if(stackTags.isEmpty()){ break; }
		}

		if(stackTags.isEmpty() && !closingTagsQueue.isEmpty()){
			return null;
		}

		return stackTags;
	}

	public static void printStack(Stack<HtmlTag> stackOfTags){
		System.out.println("The stack contains the values: ");
		String values = Arrays.toString(stackOfTags.toArray());
		System.out.println(values);
	}

	public static void printQueue(Queue<HtmlTag> queueOfTags){
		System.out.println("The queue contains the values: ");
		String values = Arrays.toString(queueOfTags.toArray());
		System.out.println(values);
	}

	public static Stack<HtmlTag> getOpeningTags(Queue<HtmlTag> tags){
		Stack<HtmlTag> openingTagStack = new Stack<>();
		// create opening tag stack
		for(HtmlTag t : tags){
			if(!t.isSelfClosing() && !t.toString().contains("/")){
				openingTagStack.push(t);
			}
		}
		System.out.println("Created a stack of opening tags: " + Arrays.toString(openingTagStack.toArray()));
		return openingTagStack;
	}

	public static Queue<HtmlTag> getClosingTags(Queue<HtmlTag> tags){
		Queue<HtmlTag> closingTagsQueue = new LinkedList<>();
		for(HtmlTag t : tags){
			if(!t.isSelfClosing() && t.toString().contains("/")){
				closingTagsQueue.add(t);
			}
		}
		return closingTagsQueue;
	}

	public static Queue<HtmlTag> cleanseClosingTags(Queue<HtmlTag> tags){
		Queue<HtmlTag> cleansedSelfClosing = new LinkedList<>();
		for(HtmlTag t : tags){
			if(!t.isSelfClosing()){
				cleansedSelfClosing.add(t);
			}
		}
		return cleansedSelfClosing;
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

