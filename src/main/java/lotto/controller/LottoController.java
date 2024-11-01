package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningRank;
import lotto.domain.WinningStatistics;
import lotto.domain.WinningStatisticsCalculator;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           LottoNumberGenerator lottoNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void start() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        Lottos lottos = getIssueLottos(purchaseAmount);
        printLottos(lottos);

        Lotto winningLotto = createWinningLotto();
        BonusNumber bonusNumber = createBonusNumber(winningLotto.getNumbers());
        processStatistics(lottos, winningLotto, bonusNumber.getBonusNumber(), purchaseAmount.getPurchaseAmount());

        Console.close();
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            String inputPurchaseAmount = inputView.inputPurchaseAmount();
            return PurchaseAmount.createPurchaseAmount(inputPurchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private Lottos getIssueLottos(PurchaseAmount purchaseAmount) {
        return LottoIssuer.issue(purchaseAmount, lottoNumberGenerator);
    }

    private void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.lottos();

        outputView.printLottoPurchaseCountMessage(lottoList.size());
        for (Lotto lotto : lottoList) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private Lotto createWinningLotto() {
        try {
            String inputWinningNumbers = inputView.inputWinningNumbers();
            return Lotto.createLotto(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createWinningLotto();
        }
    }

    private BonusNumber createBonusNumber(List<Integer> winningNumbers) {
        try {
            String bonusNumber = inputView.inputBonusNumber();
            return BonusNumber.createBonusNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createBonusNumber(winningNumbers);
        }
    }

    private void processStatistics(Lottos lottos, Lotto winningLotto, int bonusNumber, int purchaseAmount) {
        WinningStatistics winningStatistics =
                WinningStatisticsCalculator.calculateStatistics(lottos, winningLotto, bonusNumber);
        printStatistics(winningStatistics);
        calculateAndPrintReturnRate(winningStatistics, purchaseAmount);
    }

    private void printStatistics(WinningStatistics winningStatistics) {
        outputView.printWinningStatisticsHeader();
        for (WinningRank winningRank : winningStatistics.getStatistics().keySet()) {
            printWinningRankStatistics(winningRank, winningStatistics.getStatistics().get(winningRank));
        }
    }

    private void printWinningRankStatistics(WinningRank winningRank, int count) {
        outputView.printWinningStatisticsMessage(winningRank.getMessage(), winningRank.getPrizeMoney(), count);
    }

    private void calculateAndPrintReturnRate(WinningStatistics winningStatistics, int purchaseAmount) {
        double returnRate = WinningStatisticsCalculator.calculateReturnRate(winningStatistics, purchaseAmount);
        outputView.printReturnRate(returnRate);
    }

}
