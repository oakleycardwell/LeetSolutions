class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if (length == 0)
            return true;
        else if (length == 1)
            return false;
        
        
        Stack<Character> stack = new Stack();
        
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++){
            char nextChar = s.charAt(i);
            
            if (nextChar == '{' || nextChar == '[' || nextChar == '('){
                stack.push(nextChar);
            }
            else{
                if (stack.size() > 0){
                    char peek = stack.peek();
                    switch(nextChar){
                        case '}':
                            if (peek == '{')
                                stack.pop();
                            else
                                return false;
                            break;
                        case ']':
                            if (peek == '[')
                                stack.pop();
                            else
                                return false;
                            break;
                        case ')':
                            if (peek == '(')
                                stack.pop();
                            else
                                return false;
                            break;
                        default:
                            return false;
                    }
                }
                else
                    return false;
            }
        }
        
        return stack.empty();
    }
}