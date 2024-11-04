package lotto.controller;

import lotto.common.Limit;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final Lottos purchasedLottos;

    public LottoGame(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / Limit.LOTTO_PRICE;
        this.purchasedLottos = generateLottos(numberOfLottos);
    }

    private Lottos generateLottos(int count) {
        return new Lottos(
                IntStream.range(0, count)
                        .mapToObj(i -> lottoGenerator.generate())
                        .collect(Collectors.toList())
        );
    }

    public Lottos getPurchasedLottos() {
        return purchasedLottos;
    }

    public Map<LottoRank, Integer> calculateStatistics(Lotto winningLotto, int bonusNumber) {
        Lottos lottos = new Lottos(purchasedLottos.getLottos());
        return lottos.calculateRank(winningLotto, bonusNumber);
    }

    public double calculateTotalProfit(Map<LottoRank, Integer> result) {
        return result.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}


