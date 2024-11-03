package lotto.application.prize.domain;

import java.util.List;

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
                winnerNumbers.getLottoNumbers()
        );
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }
}
