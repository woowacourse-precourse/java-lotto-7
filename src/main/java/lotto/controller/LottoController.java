package lotto.controller;


import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.LottoDispenser;
import lotto.domain.LottoPurchasePrice;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoController(
            LottoInputView lottoInputView,
            LottoOutputView lottoOutputView
    ) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
    }

    public void run() {
        LottoPurchasePrice lottoPurchasePrice = retry(this::requestLottoPurchasePrice);
        LottoBundle lottoBundle = issueLottoBundle(lottoPurchasePrice);
        lottoOutputView.printLottoBundle(lottoBundle);
        WinningLotto winningLotto = retry(this::requestLottoWinningNumbers);
        BonusNumber bonusNumber = retry(this::requestLottoBonusNumber, winningLotto);
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

    private <T> T retry(Supplier<T> logic) {
        boolean retryFlag = true;
        T result = null;
        while (retryFlag) {
            try {
                result = logic.get();
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    private <T, R> R retry(Function<T, R> logic, T data) {
        boolean retryFlag = true;
        R result = null;
        while (retryFlag) {
            try {
                result = logic.apply(data);
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
