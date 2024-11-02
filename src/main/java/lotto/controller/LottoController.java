package lotto.controller;

import lotto.dto.WinningLottoResultDTO;
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

        String winningNumbers = inputView.inputWinningNumbers();
        String bonusNumber = inputView.inputBonusNumber();

        lottoService.recordWinningLottoInfo(winningNumbers, bonusNumber);
        List<WinningLottoResultDTO> formatWinningLottoResults = lottoService.formatWinningLottoResults();

        outputView.printBeforeWinningLottoInfo();
        for (WinningLottoResultDTO winningLottoResultDTO : formatWinningLottoResults) {
            outputView.printWinningLottoInfo(winningLottoResultDTO.getMatchedCount(), winningLottoResultDTO.getPrize(), winningLottoResultDTO.getCount());
        }
    }
}
