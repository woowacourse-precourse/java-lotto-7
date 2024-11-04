package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static Integer convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> convertStringToIntegerList(List<String> input) {
        List<Integer> list = new ArrayList<>();
        for (String s : input) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
