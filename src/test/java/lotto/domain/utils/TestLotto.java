package lotto.domain.utils;

import lotto.domain.model.Lotto;

import java.util.List;

public class TestLotto {

    public static Lotto createTestLotto(List<Integer> numbers) {
        return Lotto.create(numbers);
    }
}
