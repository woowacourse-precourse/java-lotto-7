package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        int buyLottoMoney = Integer.parseInt(inputView.inputBuyLottoMoney());
        int buyLottoCount = lottoService.calculateBuyLottoCount(buyLottoMoney);

        lottoService.createLottos(buyLottoCount);
        outputView.printBuyLottoCount(buyLottoCount);

        List<String> formattedLottoNumbers = lottoService.formatBuyLottoNumbersResult();

        for (String formattedLottoNumber : formattedLottoNumbers) {
            outputView.printLottoNumbers(formattedLottoNumber);
        }
    }
}
