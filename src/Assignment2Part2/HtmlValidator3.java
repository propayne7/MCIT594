package Assignment2Part2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class HtmlValidator3 {
	
	/* 
	 * Implement this method!
	 */
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		// handling of null cases
		if(tags == null){ return null; }
		if(tags.isEmpty()){ return null; }

		HtmlTag compareValue = null;
		for(HtmlTag t : tags){
			if(compareValue != null && compareValue.matches(t)){
				System.out.println("compareValue: " + compareValue + " current value: " + t);
				tags.remove(t);
			}
			compareValue = t;
		}

		// create a stack of open tag HTML elements from the tags queue (method argument)
		Stack<HtmlTag> openHtmlTagStack = new Stack<>();
		Queue<HtmlTag> closingTagQueue = new LinkedList<>();

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
			// set variables to hold the stack and queue values. this is so the if statements don't get ridiculously long
			HtmlTag stackValue = openHtmlTagStack.peek();
			HtmlTag queueValue = closingTagQueue.peek();

			if(stackValue.matches(queueValue)){
				openHtmlTagStack.pop();
				closingTagQueue.poll();
			} // check if tag is immediately opened and closed (e.g. <b></b>)
//			else if(checkFollowedByClose(tags, stackValue)){
//				openHtmlTagStack.pop();
//				for(HtmlTag t : closingTagQueue){
//					if(t.matches(stackValue)){
//						closingTagQueue.remove();
//					}
//				}
//			}
			else {
				control = false;
			}
		}

		if(openHtmlTagStack.isEmpty() && !closingTagQueue.isEmpty()){
			return null;
		}
		return openHtmlTagStack;
	}

	public static boolean checkFollowedByClose(Queue<HtmlTag> tags, HtmlTag tag){
		HtmlTag comparisonTag = null;
		for(HtmlTag t : tags){
			if(comparisonTag != null && comparisonTag.matches(t)){
				return true;
			} else {
				comparisonTag = t;
			}
		}
		return false;
	}
	/*
	 * Instructor-provided code:
	 * This function reads an HTML file and outputs its structure as the HtmlTags only.
	 * You do not need to modify this code for this assignment but can use it for your testing!
	 */

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

	public static ArrayList<HtmlTag> createArrayOfTags(Queue<HtmlTag> tags){
		ArrayList<HtmlTag> arrayOfTags = new ArrayList<>();
		for(HtmlTag t : tags){
			arrayOfTags.add(t);
		}
		return arrayOfTags;
	}

	public static ArrayList<HtmlTag> createArrayOfTags(Stack<HtmlTag> tags){
		ArrayList<HtmlTag> arrayOfTags = new ArrayList<>();
		for(HtmlTag t : tags){
			arrayOfTags.add(t);
		}
		return arrayOfTags;
	}
	
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

