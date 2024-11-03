package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Parser {

    private static final String COMMA_STRING = ",";


    public static List<Integer> convertStringToList(String string){
        return Arrays.stream(string.split(COMMA_STRING))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer convertStringToInteger(String string){
        return Integer.parseInt(string);
    }
}
