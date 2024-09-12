package Solutions.pack5_new;

import java.util.StringTokenizer;

public class MyShunting {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    private static boolean highPrecedence(String op1, String op2) {
        return order(op1) > order(op2);
    }

    public static String infixToPostfix(String infixString) {
        MyQueueExtendsLinkedList<String> queue = new MyQueueExtendsLinkedList<>();
        MyStackL stack = new MyStackL();
        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN.isNumeric(t)) {
                queue.enqueue(t);
            } else if (t.equals("(")) {
                stack.push(t);
            } else if (t.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.enqueue(stack.pop());
                }
                stack.pop(); // discard "("
            } else {
                while (!stack.isEmpty() && order(stack.peek()) >= order(t)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(t);
            }
            System.out.println("Current queue: " + queue.toString());
            System.out.println("Current stack: " + stack.toString());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        return queue.toString();
    }

}
