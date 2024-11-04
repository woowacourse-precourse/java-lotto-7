package lotto;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int parseNumber(String str){
        try {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(" 숫자를 입력해주세요");
        }

    }
    public static List<Integer> parseNumbers(String str){
        validString(str);
        String[] numberString = str.split(",");
        List<Integer> numbers = new ArrayList<>();

        for(String numStr : numberString){
            numbers.add(parseNumber(numStr.trim()));
        }
        return numbers;
    }
    private static void validString(String str){
        if(str.matches(".*[^0-9,\\s].*")){
            throw new IllegalArgumentException(" 숫자와 , 를 입력해주세요");
        }
    }
}
