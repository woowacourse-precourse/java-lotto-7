package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchResult;
import lotto.domain.PurchasedLottos;
import lotto.service.LottoChecker;
import lotto.service.LottoGenerator;
import lotto.service.WinningResult;
import lotto.view.BonusNumberInput;
import lotto.view.Output;
import lotto.view.PurchaseAmountInput;
import lotto.view.WinningNumbersInput;

public class LottoController {
    private PurchaseAmountInput purchaseAmountInput;
    private WinningNumbersInput winningNumbersInput;
    private BonusNumberInput bonusNumberInput;
    private Output output;
    private LottoGenerator generator;
    private LottoChecker checker;
    private WinningResult winningResult;

    public LottoController(PurchaseAmountInput purchaseAmountInput, WinningNumbersInput winningNumbersInput,
                           BonusNumberInput bonusNumberInput, Output output,
                           LottoGenerator generator, LottoChecker checker, WinningResult winningResult) {
        this.purchaseAmountInput = purchaseAmountInput;
        this.winningNumbersInput = winningNumbersInput;
        this.bonusNumberInput = bonusNumberInput;
        this.output = output;
        this.generator = generator;
        this.checker = checker;
        this.winningResult = winningResult;
    }

    public void run() {
        try {
            int purchaseAmount = purchaseAmountInput.input();
            PurchasedLottos purchasedLottos = generator.generateLottos(purchaseAmount);
            output.printLottoNumbers(purchasedLottos.getPurchasedLottos());

            Lotto winning = winningNumbersInput.input();
            Integer bonus = bonusNumberInput.input(winning);
            checker.setWinningNumbers(winning, bonus);

            List<MatchResult> matchResults = checker.checkLottos(purchasedLottos.getPurchasedLottos());
            winningResult.processMatchResults(matchResults);
            double profitRate = winningResult.getProfitRate(purchaseAmount);
            output.printWinningStatistics(winningResult.getStatistics(), profitRate);
        } finally {
            Console.close();
        }
    }
}
