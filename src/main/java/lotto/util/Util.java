package lotto.util;

public class Util {

    private Util() {
    }

    public static boolean isInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
