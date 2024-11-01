package lotto.controller;

import lotto.service.LottoService;
import lotto.service.Parser;
import lotto.service.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoMachine;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.CalculateResult;
import lotto.validation.InputValidator;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final InputValidator inputValidator;
    private final CalculateResult calculateResult;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
        this.inputValidator = new InputValidator();
        this.calculateResult = new CalculateResult();
    }

    public void playLotto() {
        outputView.showMoneyInputMessage();
        int money = inputValidator.validate(Parser.toInt(inputView.readLine()));
        int ticket = LottoService.divideByThousand(money);

        outputView.showPurchaseAmount(ticket);
        List<List<Integer>> lottoNumbers = lottoMachine.generateLottoNumbers(ticket);
        outputView.printLotto(lottoNumbers);

        outputView.showWinningNumberInputMessage();
        Lotto lotto = new Lotto(Splitter.splitWinningNumbers(inputView.readLine()));
        outputView.showBonusBallInputMessage();
        BonusBall bonusNumber = new BonusBall(Parser.toInt(inputView.readLine()), lotto.getNumbers());

        int[] results = calculateResult.calculateStatistics(lotto.getNumbers(), bonusNumber.getBonusNumber(), lottoNumbers);
        outputView.printStatistics(results, ticket);
    }
}
