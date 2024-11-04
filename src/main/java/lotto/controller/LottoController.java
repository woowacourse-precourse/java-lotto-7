package lotto.controller;

import lotto.util.Parser;
import lotto.util.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.LottoMachine;
import lotto.model.BonusBall;
import lotto.model.Lotto;
import lotto.model.LottoExchanger;
import lotto.model.LottoStatisticsCalculator;
import lotto.validation.InputMoneyValidator;

import java.util.List;

public class LottoController {
    private final OutputView outputView;
    private final LottoStatisticsCalculator calculateResult;
    private final InputExceptionHandler inputHandler;


    public LottoController() {
        this.outputView = new OutputView();
        this.calculateResult = new LottoStatisticsCalculator();
        this.inputHandler = new InputExceptionHandler(outputView);
    }

    public void playLotto() {
        int money = untilValidPurchaseMoney();
        int ticket = LottoExchanger.divideByThousand(money);

        outputView.showPurchaseAmount(ticket);
        List<List<Integer>> lottoNumbers = LottoMachine.generateLottoNumbers(ticket);
        outputView.printLotto(lottoNumbers);

        Lotto winningNumbers = untilValidWinningNumber();
        BonusBall bonus = untilValidBonusBall(winningNumbers);

        int[] results = calculateResult.calculateStatistics(winningNumbers.getNumbers(), bonus.getBonusNumber(), lottoNumbers);
        outputView.printStatistics(results);
        outputView.printEarningRate(calculateResult.EarningRate(calculateResult.TotalPrize(results), money));
    }

    private int untilValidPurchaseMoney() {
        return inputHandler.handleInput(() ->
                InputMoneyValidator.afterParseValidate(Parser.parseNumber(InputView.readPurchaseMoney()))
        );
    }

    private Lotto untilValidWinningNumber() {
        return inputHandler.handleInput(() ->
                new Lotto(Splitter.splitWinningNumbers(InputView.readWinningNumbers()))
        );
    }

    private BonusBall untilValidBonusBall(Lotto winningNumbers) {
        return inputHandler.handleInput(() ->
                new BonusBall(Parser.parseNumber(InputView.readBonusBall()), winningNumbers.getNumbers())
        );
    }
}