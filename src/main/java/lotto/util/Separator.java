package lotto.util;

import java.util.List;

public class Separator {
    private static final String SEPARATOR = ",";
    public static List<String> separate(String input){
        return List.of(input.split(SEPARATOR));
    }
}
