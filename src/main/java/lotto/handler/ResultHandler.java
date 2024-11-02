package lotto.handler;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.PrizeTier;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class ResultHandler {
    private final LottoService lottoService;
    private final OutputView outputView;

    public ResultHandler(LottoService lottoService, OutputView outputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void calculateAndPrintResults() {
        // 당첨 결과 계산 및 출력
        Map<PrizeTier, Long> prizeCounts = lottoService.calculateResults();

        // Long 값을 Integer로 변환하여 OutputView에 전달
        Map<PrizeTier, Integer> prizeCountsAsIntegers = prizeCounts.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue()
                ));

        outputView.printWinningResults(prizeCountsAsIntegers);
    }

    public void printProfitRate(int purchaseAmount) {
        // 수익률 계산 및 출력
        double profitRate = lottoService.calculateProfitRate(purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

}
