package lotto.controller;


import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.service.ParsingWinningNumberService;
import lotto.service.ProfitCalculatorService;
import lotto.service.RandomLottoGeneratorService;
import lotto.service.WinningNumberCheckService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private List<Lotto> randomLotto;
    private Lotto winningLotto;
    private List<LottoResult> lottoResult;

    public LottoController(List<Lotto> randomLotto, Lotto winningLotto, List<LottoResult> lottoResult) {
        this.randomLotto = randomLotto;
        this.winningLotto = winningLotto;
        this.lottoResult = lottoResult;
    }

    public void startLotto() {
        int purchase = InputView.inputPurchasePrice();
        int quantity = purchase / 1000;
        for (int i = 0; i < quantity; i++) {
            randomLotto.add(RandomLottoGeneratorService.createRandomLottoNumber());
        }

        OutputView.printIssuedLottoNumber(randomLotto, quantity);

        winningLotto = InputView.inputWinningNumber();

        int bonusNumber = InputView.inputBonusNumber();

        for (Lotto lotto: randomLotto) {
            lottoResult.add(WinningNumberCheckService.checkWinningNumber(lotto, winningLotto, bonusNumber));
        }

        Map<String, Integer> statistics = WinningNumberCheckService.calculateStatistics(lottoResult);
        double profit = ProfitCalculatorService.calculateProfit(lottoResult, purchase);
        OutputView.printWinningDetails(statistics, profit);
    }
}
