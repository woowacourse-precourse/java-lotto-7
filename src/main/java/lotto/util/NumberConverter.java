package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class NumberConverter {
    public Integer convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    public List<Integer> convertToInteger(List<String> number) {
        List<Integer> result = new ArrayList<>();

        for (String s : number) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }
}
