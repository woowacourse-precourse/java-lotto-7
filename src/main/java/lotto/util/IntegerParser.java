package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class IntegerParser {

    public List<Integer> stringToIntegerList(String input) {
        String[] numbers = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }

}
