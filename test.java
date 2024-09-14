import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

    public static String removeStars(String s) {
        ArrayList<Character> str = new ArrayList<Character>();
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            str.add(c);
        }
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i) == '*') {
                str.remove(i);
                if (i - 1 >= 0) {
                    str.remove(i - 1);
                }
                i -= 2;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char c : str) {
            sb.append(c);
        }
        return sb.toString();
    }
    
}
