package lotto.controller;

import java.util.Map;
import lotto.model.BonusNumber;
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
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);
        outputLottoResult(lottoCollection, winningNumbers, bonusNumber);
        outputReturnOfRate(lottoCollection, winningNumbers, bonusNumber);
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

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String rawInput = InputView.inputBonusNumber();
                return new BonusNumber(winningNumbers, rawInput);
            } catch (IllegalArgumentException e) {
                OutputView.outputErrorMessage(e);
            }
        }
    }

    private void outputLottoResult(LottoCollection lottoCollection, WinningNumbers winningNumbers,
                                   BonusNumber bonusNumber) {
        Map<Integer, Long> lottoWinningResult = lottoCollection.matchWinningNumbers(winningNumbers, bonusNumber);
        OutputView.outputWinningResult(lottoWinningResult);
    }

    private void outputReturnOfRate(LottoCollection lottoCollection, WinningNumbers winningNumbers,
                                    BonusNumber bonusNumber){
        double returnOfRate = money.getReturnOfRate(lottoCollection.getTotalPrize(winningNumbers, bonusNumber));
        OutputView.outputReturnOfRate(returnOfRate);
    }

}
