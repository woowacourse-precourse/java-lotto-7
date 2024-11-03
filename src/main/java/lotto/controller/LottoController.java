package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.exception.ErrorCode;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Lotto> purchasedLottos = purchaseLottos();
        WinningLotto winningLotto = processWinningLotto();
        LottoResult result = checkLottoResult(purchasedLottos, winningLotto);
        outputView.printWinningResult(result);
    }

    private List<Lotto> purchaseLottos() {
        try {
            int amount = inputView.inputPurchaseAmount();
            List<Lotto> lottos = lottoMachine.purchase(amount);
            outputView.printPurchaseAmount(lottos.size());
            outputView.printLottos(lottos);
            return lottos;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return purchaseLottos();
        }
    }

    private WinningLotto processWinningLotto() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        try {
            return inputView.inputWinningNumber();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = inputView.inputBonusNumber();
            validateBonusNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw ErrorCode.DUPLICATE_BONUS_NUMBER.throwError();
        }
    }

    private LottoResult checkLottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult(purchasedLottos.size() * 1000);
        purchasedLottos.forEach(lotto -> result.addWinningResult(lotto, winningLotto));
        return result;
    }
}