package lotto.controller;

import java.util.List;
import lotto.domain.LottoBundle;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoPurchaseResponseDto;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.service.DrawService;
import lotto.service.LottoSellingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoSellingService lottoSellingService;
    private final DrawService drawService;

    public LottoController(LottoSellingService lottoSellingService, DrawService drawService) {
        this.lottoSellingService = lottoSellingService;
        this.drawService = drawService;
    }

    public void run() {
        LottoBundle lottoBundle = purchaseLotto();
        WinningNumbers winningNumbers = setWinningNumbers();
        drawLotto(lottoBundle, winningNumbers);
    }

    private LottoBundle purchaseLotto() {
        LottoBundle lottoBundle = sellLotto();
        OutputView.displayLottoPurchase(new LottoPurchaseResponseDto(lottoBundle));
        return lottoBundle;
    }

    private WinningNumbers setWinningNumbers() {
        while (true) {
            try {
                List<Integer> mainNumbers = InputView.readWinningNumbers();
                Integer bonusNumber = InputView.readBonusNumber();
                return drawService.setWinningNumbers(new WinningNumbersRequestDto(mainNumbers, bonusNumber));
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private void drawLotto(LottoBundle lottoBundle, WinningNumbers winningNumbers) {
        LottoResultResponseDto resultDto = drawService.evaluateLottoResults(lottoBundle, winningNumbers);
        OutputView.displayLottoResult(resultDto);
    }

    private LottoBundle sellLotto() {
        while (true) {
            try {
                int amount = InputView.readPurchaseAmount();
                return lottoSellingService.sell(amount);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}
