package lotto.domain.factory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.common.util.RandomsWrapper;
import lotto.domain.entity.Lotto;

public class LottoFactory {
    private static final int LOTTO_NUMBER_LENGTH = 6;

    public static Lotto createAutoLotto() {
        return new Lotto(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_NUMBER_LENGTH) {
            numbers.add(generateRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private static Integer generateRandomNumber() {
        return RandomsWrapper.getInt();
    }
}