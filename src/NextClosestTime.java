import java.util.HashSet;

public class NextClosestTime {

    public static String nextClosestTime(String time) {
        //Step1 - convert everything to minutes - we did this so we can add 1 everytime and check if the digits are valid
        int minutes = Integer.parseInt(time.substring(0,2)) * 60; //hours to mins
        minutes += Integer.parseInt(time.substring(3)); //add the mins

        //add all 4 chars as ints to set'
        HashSet<Integer> set = new HashSet<>();
        for(char c: time.toCharArray())
            set.add(c - '0');

        while(true){
            minutes = (minutes + 1) % (24 * 60); //to convert 59 to 00
            int[] digits = {minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};

            boolean isValid = true;
            for(int digit: digits)
                if(!set.contains(digit))
                    isValid = false;

            if(isValid)
                return String.format("%02d:%02d",minutes / 60, minutes % 60);
        }
    }
    public static void main(String[] args) {
        String s = "19:34";
        System.out.println(nextClosestTime(s));
    }
}
