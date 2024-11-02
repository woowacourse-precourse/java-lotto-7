package view;

import java.util.Arrays;
import java.util.List;
import model.lotto.Lotto;
import model.money.Money;

public class PreProcessor {

    public static Money stringToMoney(String input) {
        long purchaseAmount = Long.parseLong(input);
        return Money.from(purchaseAmount);
    }

    public static Lotto stringToLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .sorted()
                .toList();
        return Lotto.from(numbers);
    }

    public static List<String> stringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .toList();
    }
}
