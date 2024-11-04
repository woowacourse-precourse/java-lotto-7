package controller;

import service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        lottoService.initializeLottoPurchaseAmount();
        lottoService.initializeLottoDrawCount();
        lottoService.generateRandomLottoNumbers();

        lottoService.printLottoNumbers();
        lottoService.initializeWinnerLottoNumbers();
        lottoService.initializeBonusNumber();
        displayLottoDrawsResult();
    }

    public void displayLottoDrawsResult() {
        lottoService.calculateLottoScore();
        lottoService.displayWinningResults();
    }

}
