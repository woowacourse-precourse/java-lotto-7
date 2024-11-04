package lotto.controller;


import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoDispenser;
import lotto.domain.LottoPurchasePrice;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.dto.LottoBundleDTO;
import lotto.dto.LottoResultDTO;
import lotto.enums.LottoConfig;
import lotto.handler.RetryHandler;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final RetryHandler retryHandler;
    private final LottoConfig lottoConfig;
    private final LottoDispenser lottoDispenser;

    public LottoController(
            LottoInputView lottoInputView,
            LottoOutputView lottoOutputView,
            RetryHandler retryHandler,
            LottoConfig lottoConfig
    ) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.retryHandler = retryHandler;
        this.lottoConfig = lottoConfig;
        this.lottoDispenser = LottoDispenser.fromConfig(lottoConfig);
    }

    public void run() {
        LottoPurchasePrice lottoPurchasePrice = retryHandler.retry(this::requestLottoPurchasePrice);
        LottoBundle lottoBundle = issueLottoBundle(lottoPurchasePrice);
        lottoOutputView.printLottoBundle(createLottoBundleDTO(lottoBundle));

        WinningLotto winningLotto = retryHandler.retry(this::requestLottoWinningNumbers);
        BonusNumber bonusNumber = retryHandler.retry(this::requestLottoBonusNumber, winningLotto);
        LottoResult lottoResult = lottoBundle.makeLottoResult(winningLotto, bonusNumber);
        lottoOutputView.printLottoResult(createLottoResultDTO(lottoResult));
    }

    private LottoPurchasePrice requestLottoPurchasePrice() {
        lottoOutputView.printLottoPurchasePrice();
        int lottoPurchasePrice = lottoInputView.readLottoPurchasePrice();
        return LottoPurchasePrice.ofPurchasePriceAndConfig(lottoPurchasePrice, lottoConfig);
    }

    private LottoBundle issueLottoBundle(LottoPurchasePrice lottoPurchasePrice) {
        return lottoDispenser.issueLottoBundle(lottoPurchasePrice);
    }

    private LottoBundleDTO createLottoBundleDTO(LottoBundle lottoBundle) {
        List<Lotto> lottos = lottoBundle.getLottos();
        return LottoBundleDTO.from(lottos);
    }

    private WinningLotto requestLottoWinningNumbers() {
        lottoOutputView.printLottoWinningNumbers();
        List<Integer> lottoWinningNumbers = lottoInputView.readLottoWinningNumbers();
        return WinningLotto.ofNumbersAndConfig(lottoWinningNumbers, lottoConfig);
    }

    private BonusNumber requestLottoBonusNumber(WinningLotto winningLotto) {
        lottoOutputView.printLottoBonusNumber();
        int lottoBonusNumber = lottoInputView.readLottoBonusNumber();
        return BonusNumber.ofNumberAndWinningLottoAndConfig(lottoBonusNumber, winningLotto, lottoConfig);
    }

    private LottoResultDTO createLottoResultDTO(LottoResult lottoResult) {
        return LottoResultDTO.ofRankCountAndProfitRate(lottoResult.getRankCount(), lottoResult.getLottoProfitRate());
    }

}
