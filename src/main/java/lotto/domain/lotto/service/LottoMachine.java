package lotto.domain.lotto.service;

import static lotto.domain.lotto.constants.LottoNumber.*;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;

public class LottoMachine {

    public Lotto create() {
        return Lotto.from(
            Randoms.pickUniqueNumbersInRange(
	MINIMUM_LOTTO_NUMBER.getCriteria(),
	MAXIMUM_LOTTO_NUMBER.getCriteria(),
	LOTTO_COUNT.getCriteria()
            )
        );
    }
}
