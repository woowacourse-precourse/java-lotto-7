package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.constant.LottoConstant;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                        LottoConstant.MIN_NUMBER.getValue(),
                        LottoConstant.MAX_NUMBER.getValue(),
                        LottoConstant.LOTTO_COUNT.getValue()
                )
        );
    }
}
