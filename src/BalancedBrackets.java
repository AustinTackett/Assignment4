import java.util.Stack;
public class BalancedBrackets {

    public static String isBalanced(String brackets) {
        if(brackets.length() == 0) {
            return "NO";
        }

        Stack<Character> bracketStack = new Stack<>(); //this line is O(1) time and space

        int listSize = 0;
        for(int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if(bracket == '{' || bracket == '[' || bracket == '(') {
                bracketStack.push(bracket);
                listSize++;
            } else if(listSize == 0) {
                return "NO"; // no open brackets indicating it can never be balanced
            } else if (bracket == '}' && bracketStack.peek() == '{') {
                bracketStack.pop();
                listSize--;
            } else if (bracket == ']' && bracketStack.peek() == '[') {
                bracketStack.pop();
                listSize--;
            } else if (bracket == ')' && bracketStack.peek() == '(') {
                bracketStack.pop();
                listSize--;
            } else {
                return "NO"; // if a non balanced bracket or non bracket character appears
            }
        }

        if (listSize == 0) {
            return "YES";
        } else {
            return "NO";
        }

    }

}
