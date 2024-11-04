package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class ChangeDataType {
    public static List<Integer> stringArrayToIntegerList(String[] inputValue) {
        List<Integer> resultValue = new ArrayList<>();

        for (String value : inputValue) {
            resultValue.add(Integer.parseInt(value.strip()));
        }

        return resultValue;
    }
}
