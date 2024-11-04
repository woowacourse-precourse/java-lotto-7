package lotto.purchase.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.checker.domain.Lotto;
import lotto.checker.domain.Lottos;
import lotto.common.NumberConstants;

import java.util.List;
import java.util.stream.LongStream;

import static lotto.common.NumberConstants.*;


public class FortuneMachine {

    long count;

    public Lottos buyLotto(Money money) {
        count = money.value() / NumberConstants.LOTTO_COST;
        return draw();
    }

    private Lottos draw() {
        return new Lottos(
                LongStream.range(0, count)
                        .mapToObj(i -> new Lotto(generateNumbers()))
                        .toList()
        );
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_LENGTH);
    }
}
