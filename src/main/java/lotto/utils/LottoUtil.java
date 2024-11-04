package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoUtil {

    public static List<Integer> splitAndParseValue(String inputValue) {
        List<String> splitString = splitInputValues(inputValue);
        return convertStringToIntList(splitString);
    }

    private static List<String> splitInputValues(String inputValue) {
        return Arrays.stream(inputValue.split(",")).toList();
    }

    private static List<Integer> convertStringToIntList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String string : stringList) {
            try {
                intList.add(Integer.parseInt(string.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
            }
        }
        return intList;
    }
}
