package homework16.app;

public class StringListProcessor {

    public static int countUpperCase(String s){
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
