package lotto.controller;

import java.util.List;
import lotto.handler.LottoInputHandler;
import lotto.handler.LottoResultHandler;
import lotto.service.LottoService;

public class LottoController {
    private final LottoInputHandler inputHandler;
    private final LottoResultHandler resultPrinter;
    private final LottoService lottoService;

    public LottoController(int lottoMoney) {
        this.inputHandler = new LottoInputHandler();
        this.resultPrinter = new LottoResultHandler();
        this.lottoService = new LottoService(lottoMoney);
    }

    public void startLotto() {
        lottoService.generateLottoSet();
        List<List<Integer>> lottoSets = lottoService.getLottoSets();
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber();
        lottoService.compareWinningNumbers(lottoSets, winningNumbers, bonusNumber);
        resultPrinter.printMatchResult(lottoService.getMatchResults());
    }
}