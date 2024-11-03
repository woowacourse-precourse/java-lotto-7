package lotto.controller;

import lotto.model.*;
import lotto.service.LottoProvideService;
import lotto.service.LottoResultService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoProvideService lottoProvideService = new LottoProvideService();
    private final LottoResultService lottoResultService = new LottoResultService();

    public void start() {
        lottoOutputView.printCashNotification();
        Cash cash = requestCashInput();

        LottoBundle lottoBundle = buyLottoBundle(cash);

        lottoOutputView.printWinningNumberNotification();
        Lotto winningLotto = requestWinningLottoInput();

        lottoOutputView.printBonusNumberNotification();
        LottoBonusNumber lottoBonusNumber = requestBonusNumberInput();

        LottoResult lottoResult = lottoResultService.calculatePrizeResult(lottoBundle, lottoBonusNumber, winningLotto, cash);
        printLottoPrizeDetails(lottoResult);
        printLottoBenefit(lottoResult.getTotalBenefit());
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
        LottoBundle lottoBundle = lottoProvideService.buyLottoBundle(cash);
        lottoOutputView.printLottoBundleAmount(lottoBundle.getLottoAmount());
        lottoOutputView.printLottoInBundle(lottoBundle);
        return lottoBundle;
    }

    private Lotto requestWinningLottoInput() {
        while (true) {
            try {
                String winningLottoNumbers = lottoInputView.getUserInput();
                return lottoProvideService.publishWinningLotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                lottoOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoBonusNumber requestBonusNumberInput() {
        while (true) {
            try {
                String bonusNumber = lottoInputView.getUserInput();
                return new LottoBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                lottoOutputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private void printLottoPrizeDetails(LottoResult lottoResult) {
        lottoOutputView.printLottoPrizesNotification();
        lottoOutputView.printLottoPrizes(lottoResult.getLottoPrizes());
    }

    private void printLottoBenefit(double totalBenefit) {
        lottoOutputView.printLottoBenefit(totalBenefit);
    }
}
