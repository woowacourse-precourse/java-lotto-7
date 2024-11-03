package lotto.domain.prize;

import java.util.List;
import lotto.WinnerNumbers;

public class PrizeNumberResult {
    private final int bonusNumber;
    private final List<Integer> winnerNumbers;

    private PrizeNumberResult(int bonusNumber, List<Integer> winnerNumbers) {
        this.bonusNumber = bonusNumber;
        this.winnerNumbers = winnerNumbers;
    }

    public static PrizeNumberResult of(BonusNumber bonusNumber, WinnerNumbers winnerNumbers) {
        return new PrizeNumberResult(
                bonusNumber.getValue(),
                winnerNumbers.getValue()
        );
    }

}
