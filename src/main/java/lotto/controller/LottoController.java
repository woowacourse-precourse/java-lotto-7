package lotto.controller;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.service.LottoPrize;
import lotto.model.service.LottoService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

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
        int purchaseAmount = getPurchaseAmount();

        List<Lotto> lottos = purchaseLotto(purchaseAmount);

        LottoWinningNumbers winningNumbers = getWinningNumbers();

        List<LottoPrize> winners = lottoService.drawWinners(lottos, winningNumbers);

        printResult(purchaseAmount, winners);

        inputView.close();
    }

    private int getPurchaseAmount() {
        outputView.printPurchaseAmountRequest();
        return inputView.getPurchaseAmount();
    }

    private List<Lotto> purchaseLotto(int purchaseAmount) {
        List<Lotto> lottos = lottoService.createLottos(purchaseAmount);
        outputView.printPurchaseLotto(lottos);
        return lottos;
    }

    private LottoWinningNumbers getWinningNumbers() {
        outputView.printWinningNumbersRequest();
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        outputView.printBonusNumberRequest();
        int bonusNumber = inputView.getBonusNumber();
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    private void printResult(int purchaseAmount, List<LottoPrize> winners) {
        double profitRatio = lottoService.calculateProfitRatio(purchaseAmount, winners);
        outputView.printWinningReport(winners);
        outputView.printProfitRatio(profitRatio);
    }
}
