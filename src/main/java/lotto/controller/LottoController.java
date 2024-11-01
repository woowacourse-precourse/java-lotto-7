package lotto.controller;


import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.LottoDispenser;
import lotto.domain.LottoPurchasePrice;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.handler.RetryHandler;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final RetryHandler retryHandler;

    public LottoController(
            LottoInputView lottoInputView,
            LottoOutputView lottoOutputView,
            RetryHandler retryHandler
    ) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.retryHandler = retryHandler;
    }

    public void run() {
        LottoPurchasePrice lottoPurchasePrice = retryHandler.retry(this::requestLottoPurchasePrice);
        LottoBundle lottoBundle = issueLottoBundle(lottoPurchasePrice);
        lottoOutputView.printLottoBundle(lottoBundle);
        WinningLotto winningLotto = retryHandler.retry(this::requestLottoWinningNumbers);
        BonusNumber bonusNumber = retryHandler.retry(this::requestLottoBonusNumber, winningLotto);
        LottoResult lottoResult = lottoBundle.makeLottoResult(winningLotto, bonusNumber);
        lottoOutputView.printLottoResult(lottoResult);
    }

    private LottoPurchasePrice requestLottoPurchasePrice() {
        lottoOutputView.printLottoPurchasePrice();
        int lottoPurchasePrice = lottoInputView.readLottoPurchasePrice();
        return LottoPurchasePrice.from(lottoPurchasePrice);
    }

    private LottoBundle issueLottoBundle(LottoPurchasePrice lottoPurchasePrice) {
        LottoDispenser lottoDispenser = new LottoDispenser();
        return lottoDispenser.issueLottoBundle(lottoPurchasePrice);
    }

    private WinningLotto requestLottoWinningNumbers() {
        lottoOutputView.printLottoWinningNumbers();
        List<Integer> lottoWinningNumbers = lottoInputView.readLottoWinningNumbers();
        return WinningLotto.from(lottoWinningNumbers);
    }

    private BonusNumber requestLottoBonusNumber(WinningLotto winningLotto) {
        lottoOutputView.printLottoBonusNumber();
        int lottoBonusNumber = lottoInputView.readLottoBonusNumber();
        return BonusNumber.of(lottoBonusNumber, winningLotto);
    }

}
