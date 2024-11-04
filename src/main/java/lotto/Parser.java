package lotto;

public class Parser {

    public static int convertStrToInt(String str){
        return Integer.parseInt(removeSpace(str));
    }


    public static String removeSpace(String str){
        return str.trim();
    }
}
