package lotto.service;

import static lotto.enums.Constants.ONE_VALUE;
import static lotto.enums.Constants.ONE_HUNDRED_VALUE;
import static lotto.enums.Constants.ZERO_VALUE;
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
            results.put(rank, results.getOrDefault(rank, ZERO_VALUE.getValue()) + ONE_VALUE.getValue());
        });
    }

    public long calculateWinningAmount() {
        return results.entrySet().stream()
                .filter(entry -> entry.getValue() > ZERO_VALUE.getValue())
                .mapToLong(entry -> (long) entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(long winningAmount, int purchaseAmount) {
        return (double) winningAmount / purchaseAmount * ONE_HUNDRED_VALUE.getValue();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
