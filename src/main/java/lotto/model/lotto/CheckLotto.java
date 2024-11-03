package lotto.model.lotto;

import java.util.List;

public class CheckLotto {
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
        double earningRatio = ((double) totalWinnings / cost) * 100;
        return String.format("%,.1f", earningRatio);
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

    private void isLottoThreeMatched(int lottoCount) {
        if (lottoCount == 3) {
            this.threeMatched++;
        }
    }

    private boolean isLottoFourMatched(int lottoCount) {
        if (lottoCount == 4) {
            this.fourMatched++;
            return true;
        }
        return false;
    }

    private boolean isLottoFiveMatched(int lottoCount) {
        if (lottoCount == 5) {
            this.fiveMatched++;
            return true;
        }
        return false;
    }

    private boolean isLottoBonusMatched(int lottoCount, boolean isBonusMatched) {
        if (lottoCount == 5 && isBonusMatched) {
            this.bonusMatched++;
            return true;
        }
        return false;
    }

    private boolean isLottoAllMatched(int lottoCount) {
        if (lottoCount == 6) {
            this.allMatched++;
            return true;
        }
        return false;
    }

    private int countLottoNumber(Lotto lotto, List<Integer> lottoNumber, int lottoCount) {
        for (int number : lotto.getNumbers()) {
            if (lottoNumber.contains(number)) {
                lottoCount++;
            }
        }
        return lottoCount;
    }

    private int calculateTotalWinnings() {
        return (5000 * threeMatched) + (50000 * fourMatched) +
                (1500000 * fiveMatched) + (30000000 * bonusMatched) +
                (2000000000 * allMatched);
    }
}
