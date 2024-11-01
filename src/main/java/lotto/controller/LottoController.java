package lotto.controller;

import lotto.model.LottoExchanger;
import lotto.util.Parser;
import lotto.util.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.LottoMachine;
import lotto.model.BonusBall;
import lotto.model.Lotto;
import lotto.model.LottoStatisticsCalculator;
import lotto.validation.InputMoneyValidator;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final InputMoneyValidator inputMoneyValidator;
    private final LottoStatisticsCalculator calculateResult;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
        this.inputMoneyValidator = new InputMoneyValidator();
        this.calculateResult = new LottoStatisticsCalculator();
    }

    public void playLotto() {
        outputView.showMoneyInputMessage();
        int money = untilValidPurchaseMoney();
        int ticket = LottoExchanger.divideByThousand(money);

        outputView.showPurchaseAmount(ticket);
        List<List<Integer>> lottoNumbers = lottoMachine.generateLottoNumbers(ticket);
        outputView.printLotto(lottoNumbers);

        outputView.showWinningNumberInputMessage();
        Lotto winningNumbers = untilValidWinningNumber();
        outputView.showBonusBallInputMessage();
        BonusBall bonus = untilValidBonusBall(winningNumbers);

        int[] results = calculateResult.calculateStatistics(winningNumbers.getNumbers(), bonus.getBonusNumber(), lottoNumbers);
        outputView.printStatistics(results, money);
    }

    private int untilValidPurchaseMoney() {
        try {
            return inputMoneyValidator.validate(Parser.parseNumber(inputView.readInputLine()));
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return (untilValidPurchaseMoney());
        }
    }

    private Lotto untilValidWinningNumber() {
        try {
            return new Lotto(Splitter.splitWinningNumbers(inputView.readInputLine()));
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return (untilValidWinningNumber());
        }
    }

    private BonusBall untilValidBonusBall(Lotto winningNumbers) {
        try {
            return new BonusBall(Parser.parseNumber(inputView.readInputLine()), winningNumbers.getNumbers());
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return (untilValidBonusBall(winningNumbers));
        }
    }
}