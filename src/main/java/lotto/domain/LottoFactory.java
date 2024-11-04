package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.common.RandomGenerator;

public class LottoFactory {
    public Lottos getLottosCountOf(int count) {
        validateIsEmpty(count);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers= RandomGenerator.createNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    private void validateIsEmpty(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("로또 갯수는 양의 정수만 가능합니다.");
        }
    }
}
