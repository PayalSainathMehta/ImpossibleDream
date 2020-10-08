import java.util.ArrayList;
import java.util.List;

public class Companies {

    static List<String> contains(List<String> companyDomains, List<String> newDomains){
        List<String> result = new ArrayList<>();
        int c = companyDomains.size();
        int n = newDomains.size();
        for(int i = 0; i < n; i++){
            String name = newDomains.get(i);
            String newhost = name.split("\\.")[0];
            String newdomain = name.split("\\.")[1];

        }
        return result;
    }

    public static void main(String[] args) {
        List<String> companyDomains = new ArrayList<>();
        List<String> newDomains = new ArrayList<>();
        companyDomains.add("palantir.com");
        companyDomains.add("apple.com");
        newDomains.add("palantir.biz");
        newDomains.add("apple.org");
        newDomains.add("appleorchard.net");
        System.out.println(contains(companyDomains, newDomains).toString());
    }
}
