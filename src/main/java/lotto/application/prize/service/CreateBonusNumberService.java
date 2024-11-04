package lotto.application.prize.service;

import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.WinnerNumbers;

public class CreateBonusNumberService {

    public BonusNumber execute(WinnerNumbers winNums, int bonus) {
        return BonusNumber.of(bonus, winNums.getLotto());
    }

}
