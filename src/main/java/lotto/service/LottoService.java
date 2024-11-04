package lotto.service;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoConstants;
import lotto.model.lotto.LottoWinningNumbers;
import lotto.model.lottoPurchaser.LottoPurchaser;
import lotto.util.LottoNumberGenerator;
import lotto.view.lottoPurchaseView.LottoPurchaseInputView;
import lotto.view.lottoPurchaseView.LottoPurchaseOutputView;
import lotto.view.winningLottoView.LottoProfitOutputView;
import lotto.view.winningLottoView.WinningLottoInputView;
import lotto.view.winningLottoView.WinningLottoOutputView;

import java.util.List;
import java.util.Set;

public class LottoService {
    private final LottoPurchaseInputView lottoPurchaseInputView;
    private final WinningLottoInputView winningLottoInputView;
    private final LottoPurchaseOutputView lottoPurchaseOutputView;
    private final WinningLottoOutputView winningLottoOutputView;
    private final LottoProfitOutputView lottoProfitOutputView;

    public LottoService(LottoPurchaseInputView lottoPurchaseInputView, WinningLottoInputView winningLottoInputView,
                        LottoPurchaseOutputView lottoPurchaseOutputView, WinningLottoOutputView winningLottoOutputView,
                        LottoProfitOutputView lottoProfitOutputView)
    {
        this.lottoPurchaseInputView = lottoPurchaseInputView;
        this.winningLottoInputView = winningLottoInputView;
        this.lottoPurchaseOutputView = lottoPurchaseOutputView;
        this.winningLottoOutputView = winningLottoOutputView;
        this.lottoProfitOutputView = lottoProfitOutputView;
    }

    public void startLotto() {
        int lottoPurchasePrice = getLottoPurchasePrice();
        int lottoPurchaseCount = calculateLottoCount(lottoPurchasePrice);
        LottoPurchaser lottoPurchaser = new LottoPurchaser(lottoPurchasePrice);

        showLottoPurchaseCount(lottoPurchaseCount);
        issueLottos(lottoPurchaser, lottoPurchaseCount);
        showLottoResult(lottoPurchaser, getWinningLottoNumbers());
    }

    private int getLottoPurchasePrice() {
        return lottoPurchaseInputView.getPurchasePrice();
    }

    private int calculateLottoCount(int lottoPurchasePrice) {
        return lottoPurchasePrice / LottoConstants.PRICE;
    }

    private void showLottoPurchaseCount(int lottoCount) {
        lottoPurchaseOutputView.showLottoPurchaseCount(lottoCount);
    }

    private void issueLottos(LottoPurchaser lottoPurchaser, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> issuedLotto = LottoNumberGenerator.generateRandomNumbers();
            lottoPurchaser.addLotto(new Lotto(issuedLotto));
            lottoPurchaseOutputView.showIssuedLottoNumbers(issuedLotto);
        }
    }

    private LottoWinningNumbers getWinningLottoNumbers() {
        Set<Integer> winningLottoNumbers = winningLottoInputView.inputWinningLottoNumbers();
        int bonusNumber = winningLottoInputView.inputBonusNumbers(winningLottoNumbers);
        return new LottoWinningNumbers(winningLottoNumbers, bonusNumber);
    }

    private void showLottoResult(LottoPurchaser lottoPurchaser, LottoWinningNumbers winningNumbers) {
        winningLottoOutputView.showLottoResult(lottoPurchaser.calculateLottoResult(winningNumbers));
        lottoProfitOutputView.showLottoProfitRate(lottoPurchaser.calculateProfitRate());
    }

}
