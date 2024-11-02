package lotto.controller;

import static lotto.view.OutputMessage.*;

import java.util.List;

import lotto.domain.dto.WinningDetail;
import lotto.domain.entity.Lotto;
import lotto.domain.factory.LottoFactory;
import lotto.domain.vo.WinningLotto;
import lotto.domain.vo.Wallet;
import lotto.domain.vo.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount amount = inputPurchaseAmount();
        Wallet wallet = purchaseLotto(amount);
        printLottoNumbers(wallet);
        WinningLotto winningLotto = inputWinningLotto();
        WinningDetail detail = wallet.winningDetail(winningLotto);
    }

    private PurchaseAmount inputPurchaseAmount() {
        outputView.print(INPUT_PURCHASE_AMOUNT);
        try {
            return PurchaseAmount.from(inputView.readLine());
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private Wallet purchaseLotto(PurchaseAmount amount) {
        int count = amount.calculateRemainder();
        outputView.print(PURCHASE_RESULT, count);
        return Wallet.from(amount);
    }

    private void printLottoNumbers(Wallet wallet) {
        List<Lotto> lottos = wallet.lottos();
        for (Lotto lotto : lottos) {
            outputView.print(String.valueOf(lotto));
        }
    }

    private WinningLotto inputWinningLotto() {
        Lotto lotto = inputWinningLottoNumbers();
        return inputWinningLottoBonusNumber(lotto);
    }

    private Lotto inputWinningLottoNumbers() {
        outputView.print(INPUT_WINNING_NUMBERS);
        String inputNumbers = inputView.readLine();
        try {
            return LottoFactory.from(inputNumbers);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return inputWinningLottoNumbers();
        }
    }

    private WinningLotto inputWinningLottoBonusNumber(Lotto lotto) {
        outputView.print(INPUT_BONUS_NUMBER);
        String inputBonus = inputView.readLine();
        try {
            return WinningLotto.of(lotto, inputBonus);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return inputWinningLottoBonusNumber(lotto);
        }
    }

}
