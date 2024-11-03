package lotto.application.prize.service;

import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;

public class CreatePrizeNumberService {

    public PrizeNumber execute(Lotto winLotto, int bonusNum) {
        BonusNumber createdBonusNum = BonusNumber.of(bonusNum, winLotto);
        WinnerNumbers createdWinNums = WinnerNumbers.of(winLotto);

        PrizeNumber prizeNumber = PrizeNumber.of(createdWinNums, createdBonusNum);

        return prizeNumber;
    }

}
