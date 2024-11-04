package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Exchanger;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final Exchanger exchanger;

    public LottoService(LottoGenerator lottoGenerator, Exchanger exchanger) {
        this.lottoGenerator = lottoGenerator;
        this.exchanger = exchanger;
    }

    public List<Lotto> purchaseLotto(Long purchasePrice) {
        return lottoGenerator.purchaseLotto(purchasePrice);
    }

    public LottoMachine generateLottoMachine(List<Integer> numbers, Integer bonusNumber) {
        return new LottoMachine(numbers, bonusNumber);
    }

    public Map<Prize, Integer> getWinningResults(LottoMachine lottoMachine, List<Lotto> lottos) {
        Map<Prize, Integer> results = initWinningResults();

        lottos.stream()
                .map(lotto -> exchanger.exchangePrize(lottoMachine, lotto))
                .forEach(prize -> results.put(prize, results.get(prize) + 1));

        return results;
    }

    public Double getRateOfReturn(Map<Prize, Integer> winningResult, Long purchasePrice) {
        Long totalPrizeAmount = getTotalPrizeAmount(winningResult);

        return Double.valueOf(totalPrizeAmount) / purchasePrice * 100;
    }

    private Map<Prize, Integer> initWinningResults() {
        Map<Prize, Integer> results = new EnumMap<>(Prize.class);

        for (Prize prize : Prize.values()) {
            results.put(prize, 0);
        }

        return results;
    }

    private Long getTotalPrizeAmount(Map<Prize, Integer> winningResult) {
        return winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }
}
