package lotto.global;

import java.util.Arrays;

public enum LottoScore {
    NO_PRIZE(0, false, "0"),
    FIFTH(3, false, "5,000"),
    FOURTH(4, false, "50,000"),
    THIRD(5, false, "1,500,000"),
    SECOND(5, true, "30,000,000"),
    FIRST(6, false, "2,000,000,000");

    private int correctLottoNumberCounts;
    private boolean correctBonusNumber;
    private String winningMoney;

    LottoScore(int correctLottoNumberCounts, boolean correctBonusNumber, String winningMoney) {
        this.correctLottoNumberCounts = correctLottoNumberCounts;
        this.correctBonusNumber = correctBonusNumber;
        this.winningMoney = winningMoney;
    }

    public static LottoScore of(int correctLottoNumberCounts, boolean correctBonusNumber) {
        return Arrays.stream(LottoScore.values())
                .filter(score -> score.correctLottoNumberCounts == correctLottoNumberCounts)
                .filter(score -> score.correctBonusNumber == correctBonusNumber)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getCorrectLottoNumberCounts() {
        return correctLottoNumberCounts;
    }

    public boolean isCorrectBonusNumber() {
        return correctBonusNumber;
    }

    public String getWinningMoney() {
        return winningMoney;
    }
}
