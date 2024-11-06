package lotto.controller;

import lotto.domain.LottoMatchType;
import lotto.util.LottoNumberGenerator;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoNumberGenerator lottoNumberGenerator, InputView inputView, OutputView outputView) {
        this.lottoService = new LottoService(lottoNumberGenerator);
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchasePrice = inputView.inputPurchasePrice();
        int lottoCount = lottoService.getLottoCount(purchasePrice);
        List<Lotto> lottos = lottoService.generateLottos(lottoCount);
        outputView.printPurchaseMessage(lottoCount);
        outputView.printLottos(lottos);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        printResult(lottos, winningNumbers, bonusNumber, purchasePrice);
    }

    private void printResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchasePrice) {
        Map<LottoMatchType, Integer> matchResult = lottoService.getMatchResult(lottos, winningNumbers, bonusNumber);
        outputView.printMatchStatistics(matchResult);
        double profitRate = lottoService.getProfitRate(matchResult, purchasePrice);
        outputView.printProfitRate(profitRate);
    }
}
