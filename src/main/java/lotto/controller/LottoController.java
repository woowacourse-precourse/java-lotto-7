package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.BonusLottoNumber;
import lotto.dto.LottoPurchaseCost;
import lotto.dto.MatchLottoResult;
import lotto.dto.RateOfReturn;
import lotto.dto.WinningLottoNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoPurchaseCost lottoPurchaseCost = inputLottoPurchaseCost();
        List<Lotto> lottos = lottoService.buyLottos(lottoPurchaseCost);
        outputView.printLottos(lottos);

        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        BonusLottoNumber bonusLottoNumber = getBonusLottoNumber(winningLottoNumbers);

        MatchLottoResult matchLottoResult = lottoService.matchLottoNumber(lottos, winningLottoNumbers, bonusLottoNumber);
        RateOfReturn rateOfReturn = lottoService.calcRateOfReturn(lottoPurchaseCost, matchLottoResult);
        outputView.printResult(matchLottoResult, rateOfReturn);
    }

    private LottoPurchaseCost inputLottoPurchaseCost() {
        while (true) {
            try {
                outputView.printLottoPurchaseCostMessage();
                return LottoPurchaseCost.from(inputView.InputLottoPurchaseAmount());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        while (true) {
            try {
                outputView.printInputLottoWinningNumbersMessage();
                return WinningLottoNumbers.from(inputView.InputLottoWinningNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private BonusLottoNumber getBonusLottoNumber(WinningLottoNumbers winningLottoNumbers) {
        while (true) {
            try {
                outputView.printInputLottoBonusNumberMessage();
                return BonusLottoNumber.from(inputView.InputLottoBonusNumber(), winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
