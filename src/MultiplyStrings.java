public class MultiplyStrings {

    //See add strings for similar solution
    //TC - O(m * n)
    //SC - O(m + n)
    static String multiply(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        if(s1.length() == 0 || s1 == null || s2.length() == 0 || s2 == null)
            return "0";
        int m = s1.length();
        int n = s2.length();
        int[] product = new int[m + n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                product[i + j] += (s1.charAt(m - 1 - i) - '0') * (s2.charAt(n - 1 - j) - '0');
            }
        }

        int carry = 0;
        for(int i = 0; i < product.length; i++){
            int sum = product[i] + carry;
            product[i] = sum % 10;
            carry = sum / 10;
        }

        if(product[product.length - 1] != 0) //dont append leading zeroes
            sb.append(product[product.length - 1]);

        for(int i = product.length - 2; i >= 0; i--) //append everything else
            sb.append(product[i]);

        return sb.toString(); //no need to reverse as product[i] is already created in reverse
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "45";
        System.out.println(multiply(s1, s2));
    }
}
