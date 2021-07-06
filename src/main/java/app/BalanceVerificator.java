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
        if ((string.length() % 2) != 0) {
            for (char c : string.toCharArray()) {
                if (c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')') {
                    if (c == '{' || c == '[' || c == '(') {
                        deque.addFirst(c);
                    } else {
                        if (!deque.isEmpty() && ((deque.peekFirst() == '{' && c == '}')
                                || (deque.peekFirst() == '[' && c == ']')
                                || (deque.peekFirst() == '(' && c == ')'))) {
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
        }
        System.out.println("BALANCED");
        return -1;
    }
}
