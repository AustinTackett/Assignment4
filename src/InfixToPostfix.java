import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostFix(String infix) {
        Stack<Character> operationStack = new Stack<>();
        Stack<Character> postFix = new Stack<>();


        char character;
        for(int i = 0; i < infix.length(); i++) {
            character = infix.charAt(i);
            if(character == '+' || character == '-' || character == '*' || character == '/' || character == '(' || character ==')' || character =='^')  {
                // Check whether to push operation to result or add it to operation stack
                updateStack(operationStack, character, postFix); // O(1)
            } else {
                postFix.push(character);
            }
        }

        // Add any operations that are not in the result already from highest precedence to lowest
        while(!operationStack.isEmpty()) {
            postFix.push(operationStack.pop());
        }

        // Turn the stack to a string
        String result = "";
        for(char output : postFix) {
            result += output;
        }
        return result;
    }

    private static int quantifyOperation(char operation) {
        if(operation == '+' || operation == '-' ) {
            return 1;
        } else if(operation == '*' || operation == '/') {
            return 2;
        } else if(operation =='^') {
            return 3;
        } else {
            return 0;
        }
    }

    private static void updateStack(Stack<Character> operationStack, char operation, Stack<Character> postFix) {
        if(operation == '('){
            operationStack.push(operation);
            return;
        } else if(operation == ')') {
            while(!operationStack.isEmpty() && operationStack.peek() != '(') {
                postFix.push(operationStack.pop());
            }
            if(operationStack.peek() == '(') {
                operationStack.pop();
            }
            return;
        }

        if(operationStack.isEmpty()) {
            operationStack.push(operation);
        } else if(operationStack.peek() == '(') {
            operationStack.push(operation);
        } else if(quantifyOperation(operationStack.peek()) < quantifyOperation(operation)) {
            operationStack.push(operation);
        } else {
            char currentChar = operation;
            while(!operationStack.isEmpty() && quantifyOperation(currentChar) <= operationStack.peek() && currentChar != '(') {
                postFix.push(operationStack.pop());

                currentChar = !operationStack.isEmpty() ? operationStack.peek(): '_';
            }
            operationStack.push(operation);
        }
    }
}
