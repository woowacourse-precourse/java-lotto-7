package lotto.controller;

import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoBundle;
import lotto.service.LottoProvider;
import lotto.service.LottoResultCalculator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoProvider lottoProvider = new LottoProvider();
    private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();

    public void start() {
        lottoOutputView.printCashNotification();
        Cash cash = requestCashInput();

        LottoBundle lottoBundle = buyLottoBundle(cash);
        lottoOutputView.printLottoBundleAmount(lottoBundle.getLottoAmount());
        lottoOutputView.printLottoInBundle(lottoBundle);

        lottoOutputView.printWinningNumberNotification();
        Lotto winningLotto = requestWinningLottoInput();

        lottoOutputView.printBonusNumberNotification();
        LottoBonusNumber lottoBonusNumber = requestBonusNumberInput();

        lottoResultCalculator.calculatePrizeResult(lottoBundle,lottoBonusNumber,winningLotto);
    }

    private Cash requestCashInput() {
        while (true) {
            try {
                String cashAmount = lottoInputView.getUserInput();
                return new Cash(cashAmount);
            } catch (IllegalArgumentException e) {
                lottoOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoBundle buyLottoBundle(Cash cash) {
        return lottoProvider.buyLottoBundle(cash);
    }

    private Lotto requestWinningLottoInput() {
        while (true) {
            try {
                String winningLottoNumbers = lottoInputView.getUserInput();
                return lottoProvider.publishWinningLotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                lottoOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoBonusNumber requestBonusNumberInput(){
        while (true) {
            try {
                String bonusNumber = lottoInputView.getUserInput();
                return new LottoBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                lottoOutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
