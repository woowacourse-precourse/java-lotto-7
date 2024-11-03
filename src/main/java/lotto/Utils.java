package lotto;

import static lotto.NumberType.LOTTO_MAX_NUMBER;
import static lotto.NumberType.LOTTO_MIN_NUMBER;
import static lotto.NumberType.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {
    private static final String DELIMITER = ",";

    public static List<String> splitNumbers(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static int convertNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_NUMBER);
        }
    }

    public static List<Integer> convertNumbers(List<String> values) {
        return values.stream()
                .map(Utils::convertNumber)
                .toList();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                LOTTO_NUMBER_COUNT);
        ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        return list;
    }
}
