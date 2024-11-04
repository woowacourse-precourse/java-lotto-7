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

        if (!isGetWinnigsMoney(winningCount)) {
            return new LottoResult("0", NO_WINNINGS_MONEY);
        }

        String winningRank = getWinningRank(winningCount, bonusCount);
        int winningsMoney = getWinningsMoney(winningRank);

        return new LottoResult(winningRank, winningsMoney);
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

    private boolean isGetWinnigsMoney(int winningCount) {
        return winningCount >= MIN_GET_WINNINGS_COUNT;
    }

    private String getWinningRank(int winningCount, int bonusCount) {
        if (winningCount + bonusCount == MAX_GET_WINNINGS_COUNT) {
            return getHighRank(bonusCount);
        }
        if (winningCount > MIN_GET_WINNINGS_COUNT) {
            if (winningCount == 5) {
                return "3";
            }
            if (winningCount == 4) {
                return "4";
            }
        }
        return "5";
    }

    private String getHighRank(int bonusCount) {
        if (bonusCount != 1) {
            return "1";
        }
        return "2";
    }

    private int getWinningsMoney(String winningRank) {
        if (winningRank.equals("1")) {
            return FIRST_WINNINGS_MONEY;
        }
        if (winningRank.equals("2")) {
            return SECOND_WINNINGS_MONEY;
        }
        if (winningRank.equals("3")) {
            return THIRD_WINNINGS_MONEY;
        }
        if (winningRank.equals("4")) {
            return FOURTH_WINNINGS_MONEY;
        }
        return FIFTH_WINNINGS_MONEY;
    }
}
