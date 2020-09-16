import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String s: emails){
            String[] parts = s.split("@");
            String new_part = parts[0].replaceAll("\\.","");
            String new_part2 = "";
            if(new_part.contains("+"))
                new_part2 = new_part.substring(0, new_part.indexOf("+"));
            else
                new_part2 = new_part;
            set.add(new_part2 + "@" + parts[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
