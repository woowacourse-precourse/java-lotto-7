package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.NumberConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

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
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
