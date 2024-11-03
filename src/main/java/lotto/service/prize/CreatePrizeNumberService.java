package lotto.service.prize;

import lotto.domain.prize.BonusNumber;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.prize.WinnerNumbers;
import lotto.domain.ticket.Lotto;

public class CreatePrizeNumberService {

    public PrizeNumber execute(int bonusNum, Lotto winLotto) {
        BonusNumber createdBonusNum = BonusNumber.of(bonusNum, winLotto);
        WinnerNumbers createdWinNums = WinnerNumbers.of(winLotto);

        PrizeNumber prizeNumber = PrizeNumber.of(createdWinNums, createdBonusNum);

        return prizeNumber;
    }

}
