package Assignment2Part2;

import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

public class HtmlValidatorRunner {
    public static void main(String[] args) throws IOException {
        HtmlValidator h = new HtmlValidator();
        Stack<HtmlTag> s = new Stack<>();

        System.out.println("Q1 Output:");
        Queue<HtmlTag> q1 = h.getTagsFromHtmlFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment2Part2\\test3.html");
        Stack<HtmlTag> s1 = h.isValidHtml(q1);
        if(s1.isEmpty()) {
            System.out.println("Empty Stack.");
        }
        System.out.println("Printing from the Runner class: ");
        for(HtmlTag z : s1){
            System.out.println(z);
        }
    }
}
