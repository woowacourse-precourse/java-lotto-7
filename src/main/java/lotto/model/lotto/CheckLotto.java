package lotto.model.lotto;

import java.util.List;

public class CheckLotto {
    public static final int PERSENT = 100;
    private int threeMatched = 0;
    private int fourMatched = 0;
    private int fiveMatched = 0;
    private int bonusMatched = 0;
    private int allMatched = 0;

    private CheckLotto() {
    }

    public static CheckLotto create() {
        return new CheckLotto();
    }

    public void checkLottoNumbers(LottoNumbers lottoNumbers, Lotto lotto, int bonusNumber) {
        for (List<Integer> lottoNumber : lottoNumbers.getLottoNumbers()) {
            int lottoCount = 0;
            boolean isBonusMatched = lottoNumber.contains(bonusNumber);

            lottoCount = countLottoNumber(lotto, lottoNumber, lottoCount);

            if (checkLottoMatched(lottoCount, isBonusMatched)) {
                continue;
            }
            isLottoThreeMatched(lottoCount);
        }

    }

    public int getThreeMatched() {
        return threeMatched;
    }

    public int getFourMatched() {
        return fourMatched;
    }

    public int getFiveMatched() {
        return fiveMatched;
    }

    public int getBonusMatched() {
        return bonusMatched;
    }

    public int getAllMatched() {
        return allMatched;
    }

    public String getEarningRatio(int cost) {
        int totalWinnings = calculateTotalWinnings();
        double earningRatio = ((double) totalWinnings / cost) * PERSENT;
        return String.format("%,.1f", earningRatio);
    }

    private int calculateTotalWinnings() {
        return (WinningStatus.FIFTH_PRIZE.getPrizeAmount() * threeMatched) + (
                WinningStatus.FOURTH_PRIZE.getPrizeAmount() * fourMatched) +
                (WinningStatus.THIRD_PRIZE.getPrizeAmount() * fiveMatched) + (
                WinningStatus.SECOND_PRIZE.getPrizeAmount() * bonusMatched) +
                (WinningStatus.FIRST_PRIZE.getPrizeAmount() * allMatched);
    }

    private boolean checkLottoMatched(int lottoCount, boolean isBonusMatched) {
        if (isLottoAllMatched(lottoCount)) {
            return true;
        }
        if (isLottoBonusMatched(lottoCount, isBonusMatched)) {
            return true;
        }
        if (isLottoFiveMatched(lottoCount)) {
            return true;
        }
        if (isLottoFourMatched(lottoCount)) {
            return true;
        }
        return false;
    }

    private boolean isLottoAllMatched(int lottoCount) {
        if (lottoCount == WinningStatus.FIRST_PRIZE.getMatchCount()) {
            this.allMatched++;
            return true;
        }
        return false;
    }

    private boolean isLottoBonusMatched(int lottoCount, boolean isBonusMatched) {
        if (lottoCount == WinningStatus.SECOND_PRIZE.getMatchCount() && isBonusMatched) {
            this.bonusMatched++;
            return true;
        }
        return false;
    }

    private boolean isLottoFiveMatched(int lottoCount) {
        if (lottoCount == WinningStatus.THIRD_PRIZE.getMatchCount()) {
            this.fiveMatched++;
            return true;
        }
        return false;
    }

    private boolean isLottoFourMatched(int lottoCount) {
        if (lottoCount == WinningStatus.FOURTH_PRIZE.getMatchCount()) {
            this.fourMatched++;
            return true;
        }
        return false;
    }

    private void isLottoThreeMatched(int lottoCount) {
        if (lottoCount == WinningStatus.FIFTH_PRIZE.getMatchCount()) {
            this.threeMatched++;
        }
    }

    private int countLottoNumber(Lotto lotto, List<Integer> lottoNumber, int lottoCount) {
        for (int number : lotto.getNumbers()) {
            if (lottoNumber.contains(number)) {
                lottoCount++;
            }
        }
        return lottoCount;
    }
}
