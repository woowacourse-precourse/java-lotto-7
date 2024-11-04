package lotto.application.prize.domain;

public class PrizeNumber {

    private final WinnerNumbers winnerNumbers;
    private final BonusNumber bonusNumber;

    public PrizeNumber(WinnerNumbers winnerNumbers, BonusNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static PrizeNumber of(WinnerNumbers winnerNumbers, BonusNumber bonusNumber) {
        return new PrizeNumber(winnerNumbers, bonusNumber);
    }

    public PrizeNumberResult getValue() {
        return PrizeNumberResult.of(bonusNumber, winnerNumbers);
    }

}
