package lotto.domain.factory;

import static lotto.common.constant.LottoConstant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.common.util.RandomsWrapper;
import lotto.domain.entity.Lotto;

public class LottoFactory {

    public static Lotto createAutoLotto() {
        return new Lotto(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < LENGTH.getValue()) {
            numbers.add(generateRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private static Integer generateRandomNumber() {
        return RandomsWrapper.getInt();
    }

    public static Lotto from(String input) {
        return new Lotto(input);
    }
}