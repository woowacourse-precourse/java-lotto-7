package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static List<String> splitNumbers(String input) {
        return Arrays.asList(input.split(","));
    }

    public static int convertNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static List<Integer> convertNumbers(List<String> values) {
        return values.stream()
                .map(Utils::convertNumber)
                .toList();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        return list;
    }
}
