package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class ListIntegerConverter {
    public static List<Integer> convertFromString(String str) {
        String[] splitedStr = str.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : splitedStr) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
