package com.afro.stacks;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
public class ParenthesesSequenceExt {

	

	// sequence = "()()" | "(({}[]))[[[" | "{}" | ...
	private static String isBalanced(String s) {
		boolean isBalanced = false;
        Stack<Character> brackets = new Stack<>();

        for (Character letter : s.toCharArray()) {
            switch (letter) {
                case '{':
                case '(':
                case '[':
                    brackets.push(letter);
                    break;
                case '}':
                    try {
                        if (brackets.peek() != null && brackets.peek().equals('{')) {
                            brackets.pop();
                            isBalanced = true;
                            break;
                        } else {
                            isBalanced = false;
                            return "NO";
                        }
                    } catch (EmptyStackException exception) {
                        isBalanced = false;
                        return "NO";
                    }
                case ')':
                    try {
                        if (brackets.peek() != null && brackets.peek().equals('(')) {
                            brackets.pop();
                            isBalanced = true;
                            break;
                        } else {
                            isBalanced = false;
                            return "NO";
                        }
                    } catch (EmptyStackException exception) {
                        isBalanced = false;
                        return "NO";
                    }
                case ']':
                    try {
                        if (brackets.peek() != null && brackets.peek().equals('[')) {
                            brackets.pop();
                            isBalanced = true;
                            break;
                        } else {
                            isBalanced = false;
                            return "NO";
                        }
                    } catch (EmptyStackException exception) {
                        isBalanced = false;
                        return "NO";
                    }

            }
        }
        return brackets.empty() ? "YES" : "NO";
	}

	public static void main(String[] args) {
		String s1 = "{[()]}"; 
		String s2 = "{[(])}";
		String s3 = "{{[[(())]]}}";
		System.out.println(isBalanced(s1));
		System.out.println(isBalanced(s2));
		System.out.println(isBalanced(s3));

		String s4 = "}";
		String s5 = "{";
		String s6 = "AB";

		System.out.println(isBalanced(s4));
		System.out.println(isBalanced(s5));
		System.out.println(isBalanced(s6));
	}
}