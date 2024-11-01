package lotto.controller;

import lotto.model.LottoExchanger;
import lotto.util.Parser;
import lotto.util.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.LottoMachine;
import lotto.model.BonusBall;
import lotto.model.Lotto;
import lotto.model.CalculateResult;
import lotto.validation.InputMoneyValidator;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final InputMoneyValidator inputMoneyValidator;
    private final CalculateResult calculateResult;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
        this.inputMoneyValidator = new InputMoneyValidator();
        this.calculateResult = new CalculateResult();
    }

    public void playLotto() {
        outputView.showMoneyInputMessage();
        int money = untilValidPurchaseMoney();
        int ticket = LottoExchanger.divideByThousand(money);

        outputView.showPurchaseAmount(ticket);
        List<List<Integer>> lottoNumbers = lottoMachine.generateLottoNumbers(ticket);
        outputView.printLotto(lottoNumbers);

        outputView.showWinningNumberInputMessage();
        Lotto lotto = untilValidWinningNumber();
        outputView.showBonusBallInputMessage();
        BonusBall bonusNumber = untilValidBonusBall(lotto);

        int[] results = calculateResult.calculateStatistics(lotto.getNumbers(), bonusNumber.getBonusNumber(), lottoNumbers);
        outputView.printStatistics(results, ticket);
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

    private BonusBall untilValidBonusBall(Lotto lotto) {
        try {
            return new BonusBall(Parser.parseNumber(inputView.readInputLine()), lotto.getNumbers());
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return (untilValidBonusBall(lotto));
        }
    }
}