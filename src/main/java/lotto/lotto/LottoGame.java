package lotto.lotto;

import java.util.Map;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoGame {

    private static final int PERCENTAGE = 100;

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberGenerator numberGenerator;

    public LottoGame(InputHandler inputHandler, OutputHandler outputHandler, NumberGenerator numberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        LottoAmount lottoAmount = inputHandler.inputPurchaseAmount();
        Lottos lottos = Lottos.purchase(lottoAmount, numberGenerator);

        outputHandler.printLotto(lottos, lottoAmount);

        WiningNumbers winingNumbers = inputHandler.inputWiningNumbers();
        LottoNumber bonusNumber = inputHandler.inputBonusNumber();
        LottoWiningNumbers lottoWiningNumbers = new LottoWiningNumbers(winingNumbers, bonusNumber);
        Map<Rank, Integer> rankSummary = lottoWiningNumbers.matchAll(lottos);

        outputHandler.printResult(rankSummary, calculateProfit(rankSummary, lottoAmount));
    }

    private double calculateProfit(Map<Rank, Integer> rankSummary, LottoAmount lottoAmount) {
        int totalAmount = getTotalAmount(rankSummary);
        return (double) totalAmount / lottoAmount.getAmount() * PERCENTAGE;
    }

    private int getTotalAmount(Map<Rank, Integer> rankSummary) {
        return rankSummary.keySet().stream()
                .mapToInt(rank -> rank.calculateRankAmount(rankSummary.get(rank)))
                .sum();
    }
}
