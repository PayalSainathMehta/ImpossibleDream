public class AddStrings {

    static String add(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = m - 1, j = n - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : s1.charAt(i) - '0';
            int y = j < 0 ? 0 : s2.charAt(j) - '0';
            sb.append((x + y + carry)%10);
            carry = (x + y) / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "45";
        System.out.println(add(s1, s2));
    }
}
