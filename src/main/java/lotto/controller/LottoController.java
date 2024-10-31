package lotto.controller;

import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoResultDto lottoDto = purchaseLotto();
        outputView.printPurchaseLottoList(lottoDto);
        receiveWinningAndBonusNumbers();
    }

    private LottoResultDto purchaseLotto() {
        while (true) {
            try {
                outputView.printPurchaseAmount();
                int price = inputView.readPrice();
                return lottoService.createLottoList(price);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void receiveWinningAndBonusNumbers() {
        while (true) {
            try {
                outputView.printWinningNumberInputMessage();
                List<Integer> winningNumbers = inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

}
