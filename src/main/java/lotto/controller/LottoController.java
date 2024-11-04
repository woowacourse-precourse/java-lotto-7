package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.io.Input;
import lotto.io.Output;
import lotto.service.LottoService;
import lotto.service.WinningNumberService;

public class LottoController {
    private final Input input;
    private final Output output;
    private final LottoService lottoService;
    private WinningNumberService winningNumberService;

    public LottoController(Input input, Output output, LottoService lottoService) {
        this.input = input;
        this.output = output;
        this.lottoService = lottoService;
    }

    public void run() {
        int amount = getAmount();
        int lottoQuantity = getLottoQuantity(amount);
        List<Lotto> lottos = createLottos(lottoQuantity);

        output.printLottoQuantity(lottoQuantity);
        output.printLottos(lottos);

        winningNumberService = new WinningNumberService(lottos, getWinningNumber(),
                getBonusNumber());

        Map<Ranking, Integer> rankingResult = getRankingResult();
        double earningsRate = getEarningsRate(rankingResult, amount);

        output.printWinningStatistics();
        output.printRanking(rankingResult);
        output.printEarningsRate(earningsRate);
    }

    private int getAmount() {
        return input.getAmount();
    }

    private int getLottoQuantity(int amount) {
        return lottoService.getLottoQuantity(amount);
    }

    private List<Lotto> createLottos(int lottoQuantity) {
        return lottoService.createLottos(lottoQuantity);
    }

    private String getWinningNumber() {
        return input.getWinningNumber();
    }

    private int getBonusNumber() {
        return input.getBonusNumber();
    }

    private Map<Ranking, Integer> getRankingResult() {
        return winningNumberService.getRankingResult();
    }

    private double getEarningsRate(Map<Ranking, Integer> rankingResult, int amount) {
        return winningNumberService.getEarningsRate(rankingResult, amount);
    }
}
