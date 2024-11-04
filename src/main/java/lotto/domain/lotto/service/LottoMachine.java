package lotto.domain.lotto.service;

import static lotto.domain.lotto.constants.LottoNumber.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.UUID;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.constants.LottoNumber;

public class LottoMachine {

    public Lotto create() {
        return Lotto.of(
            Randoms.pickUniqueNumbersInRange(
	MINIMUM_LOTTO_NUMBER.getCriteria(),
	MAXIMUM_LOTTO_NUMBER.getCriteria(),
	LOTTO_COUNT.getCriteria()
            )
        );
    }
}
