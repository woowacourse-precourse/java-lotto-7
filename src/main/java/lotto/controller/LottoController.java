package lotto.controller;

import lotto.model.LottoCollection;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Money money;

    private final LottoGenerator lottoGenerator;

    public LottoController() {
        lottoGenerator = new LottoGenerator();
    }

    public void run() {
        inputLottoPurchaseMoney();
        LottoCollection lottoCollection = generateLottoCollection(money.getLottoCount());
        outputLottoCollection(lottoCollection);
        WinningNumbers winningNumbers = inputWinningNumbers();
    }

    private void inputLottoPurchaseMoney() {
        while (true) {
            try {
                String rawInput = InputView.inputLottoPurchaseMoney();
                money = new Money(rawInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.outputErrorMessage(e);
            }
        }
    }

    private LottoCollection generateLottoCollection(int lottoCount) {
        return new LottoCollection(lottoGenerator.generateLottos(lottoCount));
    }

    private void outputLottoCollection(LottoCollection lottoCollection) {
        OutputView.outputLottoCollection(lottoCollection);
    }

    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                String rawInput = InputView.inputWinningNumbers();
                return new WinningNumbers(rawInput);
            } catch (IllegalArgumentException e) {
                OutputView.outputErrorMessage(e);
            }
        }
    }

}
