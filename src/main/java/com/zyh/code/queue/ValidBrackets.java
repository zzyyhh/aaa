package com.zyh.code.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhangyinghui  Date: 2020/9/7 Time: 10:49 AM
 */
public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid(""));
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> result = new HashMap<>();
        result.put(')','(');
        result.put( ']', '[');
        result.put( '}', '{');

        Deque<Character> stack = new LinkedList<>();

        for(int i = 0; i < chars.length; i++) {
            Character character = chars[i];
            if(result.containsKey(character)) {
                if(stack.isEmpty() || stack.peek() != result.get(character)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }
}
