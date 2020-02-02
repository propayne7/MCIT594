package Assignment2Part2;

import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

public class HtmlValidatorRunner {
    public static void main(String[] args) throws IOException {
        HtmlValidator h = new HtmlValidator();
        Stack<HtmlTag> s = new Stack<>();

        System.out.println("Q1 Output:");
        Queue<HtmlTag> q1 = h.getTagsFromHtmlFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment2Part2\\test1.html");
        Stack<HtmlTag> s1 = h.isValidHtml(q1) ;
        for(HtmlTag z : s1){
            System.out.println(z);
        }

        System.out.println();
        System.out.println();
        System.out.println("Q2 Output:");
        Queue<HtmlTag> q2 = h.getTagsFromHtmlFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment2Part2\\test2.html");
        Stack<HtmlTag> s2 = h.isValidHtml(q2);
        for(HtmlTag z : s2){
            System.out.println(z);
        }

        System.out.println();
        System.out.println();
        System.out.println("Q3:");
        Queue<HtmlTag> q3 = h.getTagsFromHtmlFile("C:\\Users\\payne\\Desktop\\MCIT\\MCIT594\\src\\Assignment2Part2\\test3.html");
        Stack<HtmlTag> s3 = h.isValidHtml(q3);
        for(HtmlTag z : s3){
            System.out.println(z);
        }
    }
}
