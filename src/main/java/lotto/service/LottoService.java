package lotto.service;

import static lotto.util.RandomUtil.generateLottoNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.enums.Rank;

public class LottoService {

    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<Rank, Integer> results = new HashMap<>();

    public void generateLottos(int lottoCount) {
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.add(new Lotto(generateLottoNumbers())));
    }

    public void saveLottoRanks(List<Integer> winningNumbers, int bonusNumber) {
        lottos.forEach(lotto -> {
            int count = lotto.countMatchingNumbers(winningNumbers);
            Rank rank = Rank.getRank(count, lotto.containsBonusNumber(bonusNumber));
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        });
    }

    public long calculateWinningAmount() {
        return results.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .mapToLong(entry -> (long) entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(long winningAmount, int purchaseAmount) {
        double profitRate = (double) winningAmount / purchaseAmount * 100.0;
        return Math.round(profitRate * 100.0) / 100.0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
