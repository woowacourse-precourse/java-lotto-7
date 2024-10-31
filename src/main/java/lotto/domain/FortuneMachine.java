package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.NumberConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class FortuneMachine {

    long count;
    List<Lotto> lottos;

    public List<Lotto> buyLotto(Money money) {
        count = money.getMoney() / NumberConstants.LOTTO_COST;
        lottos = new ArrayList<>();
        draw(count);
        return lottos;
    }

    private void draw(long count) {
        LongStream.range(0, count).forEach(i -> {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        });
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
