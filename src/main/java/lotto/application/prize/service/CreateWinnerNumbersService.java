package lotto.application.prize.service;

import java.util.List;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;

public class CreateWinnerNumbersService {

    public WinnerNumbers execute(List<Integer> winNums) {
        return WinnerNumbers.of(Lotto.of(winNums));
    }

}
