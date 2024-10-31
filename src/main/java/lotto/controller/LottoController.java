package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoRankCalculator;
import lotto.model.ProfitCalculator;
import lotto.util.InputValidator;
import lotto.model.StatisticsGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    final InputView inputView;
    final OutputView outputView;
    final LottoNumberGenerator lottoNumberGenerator;
    final LottoRankCalculator lottoRankCalculator;
    final StatisticsGenerator statisticsGenerator;
    final ProfitCalculator profitCalculator;

    public LottoController(InputView inputView, OutputView outputView, LottoNumberGenerator lottoNumberGenerator,
                           LottoRankCalculator lottoRankCalculator, StatisticsGenerator statisticsGenerator,
                           ProfitCalculator profitCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottoRankCalculator = lottoRankCalculator;
        this.statisticsGenerator = statisticsGenerator;
        this.profitCalculator = profitCalculator;
    }

    public void run() {
        long purchaseAmount = purchaseAmountController();
        System.out.println();

        List<Lotto> lotto = lottoNumberGenerator.getLotto(purchaseAmount / 1000);
        outputView.printPurchasedLotto(lotto);
        System.out.println();

        Lotto winningNumbers = winningNumbersController();
        System.out.println();

        int bonusNumber = bonusNumberController();
        System.out.println();

        statisticsGenerator.makeStatistics(lotto, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> statistics = statisticsGenerator.getStatistics();

        outputView.printStatistics(statistics);

        double rateOfReturn = profitCalculator.getProfit(purchaseAmount, statistics);
        outputView.printRateOfReturn(rateOfReturn);

    }

    public long purchaseAmountController() {
        try {
            String purchaseAountInput = inputView.getPurchaseAmount();
            InputValidator.isNotNumber(purchaseAountInput);
            return Long.parseLong(purchaseAountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseAmountController();
        }
        return 0;
    }

    public Lotto winningNumbersController() {
        try {
            List<String> inputWinningNumbers = Arrays.asList(inputView.getWinningNumbers().split(","));
            InputValidator.isNotNumber(inputWinningNumbers);
            List<Integer> convertedWinningNumbers = inputWinningNumbers.stream().map(Integer::parseInt).toList();
            return new Lotto(convertedWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumbersController();
        }
        return null;
    }


    public int bonusNumberController() {
        try {
            String bonusNumberInput = inputView.getBonusNumber();
            InputValidator.isNotNumber(bonusNumberInput);
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            InputValidator.validateRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumberController();
        }
        return 0;
    }

}
