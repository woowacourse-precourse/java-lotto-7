package lotto.domain.utils;

import lotto.domain.model.user.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestLotto {

    public static Lotto createTestLotto(List<Integer> numbers) {
        return Lotto.create(numbers);
    }

    public static List<Lotto> createTestLottos(Lotto... lottos) {
        List<Lotto> testLottos = new ArrayList<>();
        Collections.addAll(testLottos, lottos);
        return testLottos;
    }
}
