package lotto.controller;

import lotto.dto.LottoPurchasedAmountInput;
import lotto.dto.WinnerLottoNumbersInput;
import lotto.exception.LottoException;
import lotto.model.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Buyer;

public class LottoController {

    private final InputView inputView;
    private final OutputView outPutView;

    public LottoController(InputView inputView, OutputView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    public void start() {
        Buyer buyer = processLottoPurchase();
        WinnerLotto winnerLotto = processWinnerLotto();
    }

    private Buyer processLottoPurchase() {
        while (true) {
            try {
                LottoPurchasedAmountInput lottoPurchasedAmountInput = inputView.readLottoPurchasedAmount();

                return Buyer.from(lottoPurchasedAmountInput.rawAmount());
            } catch (LottoException e) {
                outPutView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinnerLotto processWinnerLotto() {
        while (true) {
            try {
                WinnerLottoNumbersInput winnerLottoNumbersInput = inputView.readWinnerLottoNumbers();
                return WinnerLotto.from(winnerLottoNumbersInput.rawNumbers());
            } catch (LottoException e) {
                outPutView.printErrorMessage(e.getMessage());
            }
        }
    }
}
