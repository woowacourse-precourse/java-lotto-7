package lotto.controller;

import lotto.domain.Lottery;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.service.LottoMachineService;
import lotto.service.LottoResultService;
import lotto.service.ProfitCalculatorService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoMachineService lottoMachineService;
    private final LottoResultService resultService;
    private final ProfitCalculatorService profitService;

    public LottoController() {
        this.lottoMachineService = new LottoMachineService(new LottoMachine());
        this.resultService = new LottoResultService();
        this.profitService = new ProfitCalculatorService();
    }

    public void start() {
        int amount = inputPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(amount);
        OutputView.printPurchaseResult(purchasedLottos);

        Lottery lottery = inputWinningNumbers();

        Map<String, Integer> results = calculateResults(purchasedLottos, lottery);
        OutputView.printStatisticsResult(results);

        double profitRate = calculateProfitRate(results, amount);
        OutputView.printProfitRate(profitRate);
    }

    private int inputPurchaseAmount() {
        return InputView.inputPurchaseAmount();
    }

    private List<Lotto> generateLottos(int amount) {
        Money money = new Money(amount);
        return lottoMachineService.purchaseLottos(money);
    }

    private Lottery inputWinningNumbers() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = InputView.inputBonusNumber();
        return new Lottery(winningLotto, bonusNumber);
    }

    private Map<String, Integer> calculateResults(List<Lotto> purchasedLottos, Lottery lottery) {
        return resultService.calculateResults(purchasedLottos, lottery);
    }

    private double calculateProfitRate(Map<String, Integer> results, int amount) {
        return profitService.calculateProfit(results, amount);
    }
}
