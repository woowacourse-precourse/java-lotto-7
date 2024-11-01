package lotto.io.preprocessor;

import static java.util.Comparator.naturalOrder;

import java.util.Arrays;
import java.util.List;
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

    public static Integer stringToInteger(String source) {
        return Integer.valueOf(source);
    }

}
