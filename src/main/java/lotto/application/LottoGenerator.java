package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoGenerator {

    public Lotto generate() {
        List<Integer> LottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lotto.of(LottoNumbers);
    }
}
