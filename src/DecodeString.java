import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {

    static String decodeString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']')
            {
                List<Character> decodedString = new ArrayList<>();
                while(stack.peek() != '['){
                    decodedString.add(stack.pop());
                }
                stack.pop();
                int k = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k += (stack.pop()- '0') * base;
                    base *= 10;
                }

                //we try to append for k times in the string
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
            else
                stack.push(c);

        }
        char[] result = new char[stack.size()];
        for(int i = result.length - 1; i >=0 ; i--)
            result[i] = stack.pop();

        return new String(result);
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
