package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoGenerator {

    private static LottoGenerator instance;

    private LottoGenerator() {

    }

    public static LottoGenerator getInstance() {
        if (instance == null) {
            instance = new LottoGenerator();
        }
        return instance;
    }

    public Lotto generate() {
        List<Integer> LottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lotto.of(LottoNumbers);
    }
}
