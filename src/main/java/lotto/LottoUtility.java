package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoUtility {
    public static List<Integer> stringToWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
        return numbers;
    }
}
