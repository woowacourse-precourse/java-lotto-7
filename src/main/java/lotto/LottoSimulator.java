package lotto;

import java.util.List;
import java.util.Map;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.lotto.LottoWinningNumbers;
import lotto.lotto.Lottos;

public class LottoSimulator {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private int lottoDrawStatus = 0;

    public LottoSimulator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        int lottoCount = getLottoCountFromUser();

        Lottos lottos = pickLottoNumbers(lottoCount);
        List<Integer> winningNumbers = getWinningNumbersFromUser();
        int bonusNumber = getBonusNumberFromUser(winningNumbers);

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.of(winningNumbers, bonusNumber);

        int totalWinningPrice = actLottoDraw(lottos, lottoWinningNumbers);

        totalProfitRate(totalWinningPrice, lottoCount);
    }

    private void totalProfitRate(int totalWinningPrice, int lottoCount) {
        double profitRate = ProfitCalculator.calculateProfitRate(totalWinningPrice, lottoCount);
        outputHandler.showLottoTotalProfitRate(profitRate);
        lottoDrawStatus = 1;
    }

    private int actLottoDraw(Lottos lottos, LottoWinningNumbers lottoWinningNumbers) {
        Map<String, Integer> lottoResult = lottos.lottoDraw(lottoWinningNumbers);
        outputHandler.showLottoStatistics(lottoResult);

        return lottos.totalWinningPrice(lottoResult);
    }

    private Lottos pickLottoNumbers(int lottoCount) {
        Lottos lottos = Lottos.of(lottoCount);
        outputHandler.showLottoCountComments(lottoCount);
        outputHandler.showLottoNumbersComments(lottos);

        return lottos;
    }

    private int getLottoCountFromUser() {
        outputHandler.showLottoPurchaseComments();
        return inputHandler.getLottoPurchaseFromUser();
    }

    private int getBonusNumberFromUser(List<Integer> winningNumbers) {
        outputHandler.showBonusNumberComments();
        return inputHandler.getBonusNumberFromUser(winningNumbers);
    }

    private List<Integer> getWinningNumbersFromUser() {
        outputHandler.showWinningNumbersComments();
        return inputHandler.getWinningNumbersFromUser();
    }

    private boolean isLottoDrawComplete() {
        return lottoDrawStatus == 1;
    }

}
