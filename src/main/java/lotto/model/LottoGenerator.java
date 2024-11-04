package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoGenerator {

    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 45;
    private static final int LOTTO_COUNT = 6;

    public Lottos generateLottos(int lottoCount) {
        return new Lottos(Stream.generate(this::generateLotto)
                .limit(lottoCount)
                .toList());
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_OF_RANGE, END_OF_RANGE, LOTTO_COUNT)
                .stream()
                .sorted()
                .toList()
        );
    }
}
