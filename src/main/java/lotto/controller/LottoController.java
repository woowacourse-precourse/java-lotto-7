package lotto.controller;

import static lotto.util.Validator.validateBonusNumber;
import static lotto.util.Validator.validatePurchaseAmount;
import static lotto.util.Validator.validateWinningNumbers;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmount = validatePurchaseAmount(inputPurchaseAmount);
        int lottoCount = purchaseAmount / 1000;
        lottoService.generateLottos(lottoCount);
        outputView.printLottoCount(lottoCount);

        List<Lotto> lottos = lottoService.getLottos();
        lottos.forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));

        String inputWinningNumbers = inputView.inputWinningNumbers();
        List<Integer> winningNumbers = validateWinningNumbers(inputWinningNumbers);
        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = validateBonusNumber(winningNumbers, inputBonusNumber);

        lottoService.saveLottoRanks(winningNumbers, bonusNumber);
        Map<Rank, Integer> results = lottoService.getResults();

        outputView.printWinningStatisticsHeader();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            if (rank.isRequiresBonus()) {
                outputView.printMatchWithBonusResult(
                        rank.getMatchCount(),
                        rank.getWinningAmount(),
                        results.getOrDefault(rank, 0)
                );
                continue;
            }
            outputView.printMatchResult(
                    rank.getMatchCount(),
                    rank.getWinningAmount(),
                    results.getOrDefault(rank, 0)
            );
        }

        long winningAmount = lottoService.calculateWinningAmount();
        double profitRate = lottoService.calculateProfitRate(winningAmount, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }
}
