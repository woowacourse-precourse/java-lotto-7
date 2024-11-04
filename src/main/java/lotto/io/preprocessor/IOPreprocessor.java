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

    public static String cleanWhiteBlanks(final String source) {
        return source.strip();
    }

    public static Money stringToMoney(final String source) {
        long purchaseAmount = Long.parseLong(source);
        return Money.from(purchaseAmount);
    }

    public static Lotto stringToLotto(final String source) {
        List<Integer> enteredNumbers = Arrays.stream(source.split(","))
                .map(String::strip)
                .map(Integer::valueOf)
                .sorted(naturalOrder())
                .toList();
        return Lotto.from(enteredNumbers);
    }

    public static List<String> stringToListString(final String source) {
        return Arrays.stream(source.split(","))
                .map(String::strip)
                .toList();
    }

    public static Set<String> stringToSetString(final String source) {
        return Arrays.stream(source.split(","))
                .map(String::strip)
                .collect(Collectors.toSet());
    }

    public static Integer stringToInteger(final String source) {
        return Integer.valueOf(source);
    }

}
