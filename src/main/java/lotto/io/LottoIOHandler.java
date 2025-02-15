package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.statistic.Statistic;

public class LottoIOHandler {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public long askPurchaseCost() {
        outputHandler.showPurchaseCostInputComments();

        long purchaseCost = 0;

        while (purchaseCost == 0) {
            try {
                purchaseCost = inputHandler.getPurchaseCost();

            } catch (IllegalArgumentException e) {
                outputHandler.showErrorMessage(e.getMessage());
            }
        }
        return purchaseCost;
    }

    public WinningLotto askWinningLotto() {

        outputHandler.showWinningLottoInputComment();

        List<Integer> winningLottoNumbers = getWinningLottoNumber();

        outputHandler.showWinningLottoBonusNumberInputComment();

        return getWinningLotto(winningLottoNumbers);

    }

    private WinningLotto getWinningLotto(List<Integer> winningLottoNumbers) {
        WinningLotto winningLotto = null;

        while (winningLotto == null) {
            try {
                Integer bonusNum = getWinningLottoBonusNumber();
                winningLotto = new WinningLotto.Builder()
                        .numbers(winningLottoNumbers)
                        .bonusNumber(bonusNum)
                        .build();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    private List<Integer> getWinningLottoNumber() {
        List<Integer> winningLottoNumbers = new ArrayList<>();

        while (winningLottoNumbers.isEmpty()) {
            try {
                winningLottoNumbers = inputHandler.getWinningLottoInput();
                WinningLotto.Builder builder = new WinningLotto.Builder().numbers(winningLottoNumbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningLottoNumbers.clear();
            }
        }
        return winningLottoNumbers;
    }

    private Integer getWinningLottoBonusNumber() {
        Integer bonusNum = null;

        while (bonusNum == null) {
            try {
                bonusNum = inputHandler.getWinningLottoBonusNumberInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bonusNum = null;
            }
        }
        return bonusNum;
    }

    public void showPurchaseLottoCount(long lottoCount) {
        outputHandler.showPurchaseLottoCount(lottoCount);
    }

    public void showNumber(Lotto lotto) {
        outputHandler.showNumber(lotto);
    }

    public void showWinningStatistics(Statistic statistic) {
        outputHandler.showWinningStatistics(statistic);
    }

    public void showInterestRate(double interestRate) {
        outputHandler.showInterestRate(interestRate);
    }
}
