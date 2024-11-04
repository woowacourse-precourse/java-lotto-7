package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.statistic.Statistic;

public class LottoIOHandler {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public long askPurchaseCost (){
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
        List<Integer> winningLottoNumber = new ArrayList<>();

        while (winningLottoNumber.isEmpty()) {
            try {
                winningLottoNumber = inputHandler.getWinningLottoInput();

                WinningLotto.Builder builder = new WinningLotto.Builder().numbers(winningLottoNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningLottoNumber.clear();
            }
        }
        outputHandler.showWinningLottoBonusNumberInputComment();
        Integer bonusNum = inputHandler.getWinningLottoBonusNumberInput();

        WinningLotto winningLotto = new WinningLotto.Builder()
                .numbers(winningLottoNumber)
                .bonusNumber(bonusNum)
                .build();
        return winningLotto;
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
