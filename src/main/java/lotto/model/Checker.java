package lotto.model;

public class Checker {
    private Lotto winningNumbers;
    private int bonusNumber;
    private static final int NO_WINNINGS_MONEY = 0;
    private static final int FIFTH_WINNINGS_MONEY = 5000;
    private static final int FOURTH_WINNINGS_MONEY = 50000;
    private static final int THIRD_WINNINGS_MONEY = 1500000;
    private static final int SECOND_WINNINGS_MONEY = 30000000;
    private static final int FIRST_WINNINGS_MONEY = 2000000000;
    private static final int MIN_GET_WINNINGS_COUNT = 3;
    private static final int MAX_GET_WINNINGS_COUNT = 6;


    public Checker(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    public LottoResult check(Lotto lotto) {
        int winningCount = calculateWinningCount(lotto);
        int bonusCount = calculateBonusCount(lotto);
    }

    private int calculateWinningCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(number -> winningNumbers.getLottoNumbers().contains(number))
                .count();
    }

    private int calculateBonusCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(number -> number == bonusNumber)
                .count();
    }


}
