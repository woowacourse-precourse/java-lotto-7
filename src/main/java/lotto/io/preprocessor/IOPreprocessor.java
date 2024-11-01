package lotto.io.preprocessor;

import static java.util.Comparator.naturalOrder;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;

public class IOPreprocessor {

    private IOPreprocessor() {
    }

    public static Money stringToMoney(String source) {
        long purchaseAmount = Long.parseLong(source);
        return Money.from(purchaseAmount);
    }

    public static Lotto stringToLotto(String source) {
        List<Integer> enteredNumbers = Arrays.stream(source.split(","))
                .map(String::strip)
                .map(Integer::valueOf)
                .sorted(naturalOrder())
                .toList();
        return Lotto.from(enteredNumbers);
    }

    public static List<String> stringToListString(String source) {
        return Arrays.stream(source.split(","))
                .map(String::strip)
                .toList();
    }

    public static Set<String> stringToSetString(String source) {
        return Arrays.stream(source.split(","))
                .map(String::strip)
                .collect(Collectors.toSet());
    }

    public static Integer stringToInteger(String source) {
        return Integer.valueOf(source);
    }

}
