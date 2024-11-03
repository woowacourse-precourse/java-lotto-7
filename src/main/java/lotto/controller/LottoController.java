package lotto.controller;

import java.util.Arrays;
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

        List<Integer> winningNumbers =
                Arrays.stream(inputView.inputWinningNumbers().split(","))
                        .map(Integer::parseInt)
                        .toList();
        String bonusNumber = inputView.inputBonusNumber();

        lottoService.saveLottoRanks(winningNumbers, Integer.parseInt(bonusNumber));
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
        double profitRate = lottoService.calculateProfitRate(winningAmount, Long.parseLong(purchaseAmount));
        outputView.printProfitRate(profitRate);
    }
}
