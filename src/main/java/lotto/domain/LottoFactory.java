package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private final int cost;
    private final int count;
    private final int divideUnit = 1000;

    public LottoFactory(String cost) {
        this.cost = parseOrThrow(cost);
        this.count = this.calculateCountOrThrow();
    }

    public List<Lotto> generate() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottos.add(makeNewLotto());
        }
        return lottos;
    }

    private Lotto makeNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private int parseOrThrow(String count) {
        try {
            return Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.numberParseError);
        }
    }

    private int calculateCountOrThrow() {
        if (this.cost % divideUnit != 0) {
            throw new IllegalArgumentException(ErrorMessage.cantDividedInto1000);
        }
        return this.cost / divideUnit;
    }
}
