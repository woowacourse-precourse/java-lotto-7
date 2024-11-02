package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.Money;
import lotto.domain.type.LottoRank;
import lotto.dto.response.LottoCalculateResponse;

public class LottoService {

    private final Map<LottoRank, Integer> prizeCounts = new HashMap<>();

    public LottoService() {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> prizeCounts.put(rank, 0));
    }

    public Lottoes createLottoes(Money money) {
        return Lottoes.from(money);
    }

    public LottoCalculateResponse calculateLotto(Lottoes lottoes, Lotto ownLotto, int bonusNumber, Money money) {
        for (Lotto target : lottoes.getLottoes()) {
            LottoRank prize = calculatePrizeCount(target, ownLotto, bonusNumber);
            prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
        }

        return LottoCalculateResponse.of(prizeCounts, calculateEarningRate(money));
    }

    private LottoRank calculatePrizeCount(Lotto target, Lotto ownLotto, int bonusNumber) {
        return target.match(ownLotto, bonusNumber);
    }

    private double calculateEarningRate(Money money) {
        int totalPrize = prizeCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double earningRate = ((double) totalPrize / money.getValue()) * 100;

        return Math.round(earningRate * 100.0) / 100.0;
    }
}
