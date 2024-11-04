package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.global.message.InputMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Lottos purchasedLottos = initLotts();
        printPurchaseResult(purchasedLottos);

        WinningNumbers winningNumbers = inputWinningNumbers();

        printLottoResults(purchasedLottos, winningNumbers);
    }

    private Lottos initLotts() {
        try {
            Money money = Money.wons(InputView.inputNumber(InputMessage.PURCHASE_AMOUNT));
            return Lottos.autoGenerate(money.getLottoQuantity());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return initLotts();
        }
    }

    private void printPurchaseResult(Lottos purchasedLottos) {
        OutputView.printPurchaseResult(purchasedLottos);
    }

    private WinningNumbers inputWinningNumbers() {
        Lotto winnerLotto = inputLotto();
        OutputView.printNewEmptyLine();

        BonusNumber bonusNumber = createBonusNumber();
        return createWinningNumbers(winnerLotto, bonusNumber);
    }

    private Lotto inputLotto() {
        try {
            List<Integer> mainWinningNumbers = InputView.inputWinningLotto(InputMessage.WINNING_NUMBERS);
            return Lotto.from(mainWinningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputLotto();
        }
    }

    private WinningNumbers createWinningNumbers(Lotto winnerLotto, BonusNumber bonusNumber) {
        try {
            return WinningNumbers.of(winnerLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return createWinningNumbers(winnerLotto, createBonusNumber());
        }
    }

    private BonusNumber createBonusNumber() {
        try {
            return BonusNumber.from((int) InputView.inputNumber(InputMessage.BONUS_NUMBER));
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return createBonusNumber();
        }
    }

    private void printLottoResults(Lottos purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = createLottoResult(purchasedLottos, winningNumbers);
        double returnRate = calculateReturnRate(purchasedLottos, lottoResult);
        OutputView.printLottoResults(lottoResult, returnRate);
    }

    private LottoResult createLottoResult(Lottos purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(purchasedLottos, winningNumbers);
        return lottoResult;
    }

    private double calculateReturnRate(Lottos purchasedLottos, LottoResult lottoResult) {
        return lottoResult.calculateReturnRate((long) purchasedLottos.getSize() * Money.getLottoPriceUnit());
    }
}