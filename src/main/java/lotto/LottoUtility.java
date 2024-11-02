package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoUtility {
    public static void validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if(amount % 1000 > 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000 단위로 입력하셔야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력하셔야 합니다.");
        }
    }

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
