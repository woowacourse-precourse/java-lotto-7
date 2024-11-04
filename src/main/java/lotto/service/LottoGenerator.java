package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.util.Constants;

public class LottoGenerator implements Generator<Lotto> {

    @Override
    public Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_SIZE));
    }
}
