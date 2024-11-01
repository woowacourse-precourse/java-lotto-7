package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Guess;
import lotto.domain.Lotto;
import lotto.enums.Rank;
import lotto.service.GenerateRandomNumbers;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.service.ProfitCalculatorService;
import lotto.service.ValidatorService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final GenerateRandomNumbers generateRandomNumbers;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResultService lottoResultService;
    private final ProfitCalculatorService profitCalculatorService;

    public LottoController() {
        LottoService lottoService = new LottoService();
        this.generateRandomNumbers = new GenerateRandomNumbers();
        this.inputView = new InputView(new ValidatorService(), lottoService);
        this.outputView = new OutputView();
        this.lottoResultService = new LottoResultService();
        this.profitCalculatorService = new ProfitCalculatorService();
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseInput();
        int numberOfLottos = purchaseAmount / 1000;

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            purchasedLottos.add(new Lotto(generateRandomNumbers.generateLottoNumbers()));
        }
        outputView.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = inputView.getLottoInput();
        Guess guess = inputView.getBonusNumberInput(winningNumbers);

        List<Rank> results = lottoResultService.determineRanks(guess, purchasedLottos);
        outputView.printWinningStatistics(results, purchaseAmount);

        Map<Rank, Long> rankCount = results.stream()
                .filter(rank -> rank != Rank.NONE)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
        double profitRate = profitCalculatorService.calculateProfit(rankCount, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }
}
