package lotto.domain.factory;

import java.util.ArrayList;
import java.util.List;

import lotto.common.util.RandomsWrapper;
import lotto.domain.entity.Lotto;

public class LottoFactory {

    public static Lotto createAutoLotto() {
        return new Lotto(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        return new ArrayList<>(generateRandomNumber());
    }

    private static List<Integer> generateRandomNumber() {
        return RandomsWrapper.getInt();
    }

    public static Lotto from(String input) {
        return new Lotto(input);
    }
}