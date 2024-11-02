package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.LongStream;

import static lotto.LottoConstants.*;

public class LottoMachine {
    private final Lottos lottos = new Lottos();

    public Lottos issue(long lottoCount) {
        LongStream.range(0, lottoCount).forEach(i -> {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.addLotto(lotto);
        });
        return lottos;
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_SIZE);
    }
}
