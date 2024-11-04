package lotto.factory;

import lotto.model.Lotto;

import java.util.List;

public abstract class LottoFactory {
    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}