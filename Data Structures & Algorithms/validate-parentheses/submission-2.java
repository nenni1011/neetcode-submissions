class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack <Character> ();
        for(char ch : s.toCharArray()){
            if(isOpenBracket(ch)) st.push(ch);
            else{
                if(!st.isEmpty() && isPair(ch, st.peek())) st.pop();
                else st.push(ch);
            }
        }
        return st.isEmpty();
    }


    public boolean isOpenBracket(char ch){
        return ch == '[' || ch == '{' || ch == '(';
    }


    public boolean isPair(char close, char open){
        if(close == ']' && open == '[') return true;
        else if(close == '}' && open == '{') return true;
        else if(close == ')' && open == '(') return true;
        else return false;
    }
}
