package lotto.utils;

import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;

public class PreProcessor {

    public static Money stringToMoney(final String input) {
        long purchaseAmount = Long.parseLong(input);
        return Money.of(purchaseAmount);
    }

    public static Lotto stringToLotto(final String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .sorted()
                .toList();
        return Lotto.from(numbers);
    }

    public static List<String> stringToStringList(final String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .toList();
    }

    public static Integer stringToInteger(final String input) {
        return Integer.parseInt(input);
    }
}
