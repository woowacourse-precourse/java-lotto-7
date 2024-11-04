package lotto.controller;

import lotto.dto.LottoDto;
import lotto.dto.LottoWinningNumbersDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;
import lotto.model.service.LottoService;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {

    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            LottosDto purchaselottosDto = purchaseLottos();
            drawLottos(purchaselottosDto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private LottosDto purchaseLottos() {
        while (true){
            try {
                long purchaseAmount = lottoView.requestLottoPurchaseAmount();
                LottosDto purchasedLottos = lottoService.buyLottos(purchaseAmount);
                lottoView.displayPurchaseInfo(purchasedLottos);
                return purchasedLottos;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void drawLottos(LottosDto purchasedLottos) {
        LottoWinningNumbersDto winningNumbersDto = setWinningNumbersAndBonus();

        List<RankResultDto> rankResults = lottoService.calculateResults(winningNumbersDto, purchasedLottos);
        lottoView.displayResults(rankResults);

        double profitRate = lottoService.calculateProfitRate(rankResults);
        lottoView.displayWinningStatistics(profitRate);
    }

    private LottoWinningNumbersDto setWinningNumbersAndBonus() {
        return new LottoWinningNumbersDto(getMainWinningNumbers(), getBonusNumber());
    }

    private LottoDto getMainWinningNumbers() {
        while (true) {
            try {
                return lottoView.requestWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return lottoView.requestBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}