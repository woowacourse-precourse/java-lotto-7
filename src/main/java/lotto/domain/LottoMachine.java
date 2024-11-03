package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lottoForm.Lotto;

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

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
    }
}
