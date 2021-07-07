package app;

import java.util.Deque;
import java.util.LinkedList;

public class BalanceVerificator {

    /**
     * @param string of brackets
     * @return -1 if brackets is balanced otherwise return a number of not balanced brackets
     */
    public int checkBrackets(String string) {
        Deque<Character> deque = new LinkedList<>();
        char[] ch = string.toCharArray();
        for (char c : ch) {
            if (c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')') {
                if (c == '{' || c == '[' || c == '(') {
                    deque.addFirst(c);
                } else {
                    if (c == ']' && !deque.isEmpty() && deque.peekFirst() == '['
                            || c == '}' && !deque.isEmpty() && deque.peekFirst() == '{'
                            || c == ')' && !deque.isEmpty() && deque.peekFirst() == '(') {
                        deque.removeFirst();
                    } else {
                        System.out.println("NOT BALANCED (" + deque.size() + ")");
                        return deque.size();
                    }
                }
            } else {
                throw new IllegalArgumentException("A character doesn’t belong to any known brackets type");
            }
        }
        System.out.println("BALANCED");
        return -1;
    }
}
