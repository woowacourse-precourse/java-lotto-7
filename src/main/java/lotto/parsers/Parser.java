package lotto.parsers;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<Integer> parseStringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static boolean isInteger(String input) {
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
