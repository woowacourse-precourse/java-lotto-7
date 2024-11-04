package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoMoney;
import lotto.domain.Rank;

public class LottoResult {

    private final Map<Rank, Integer> result = new LinkedHashMap<>();

    private LottoResult() {
        for (Rank values : Rank.values()) {
            result.put(values, 0);
        }
    }

    public static LottoResult from(List<Rank> ranks) {
        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> result = lottoResult.result;
        for (Rank rank : ranks) {
            result.put(rank, result.get(rank) + 1);
        }

        return lottoResult;
    }

    public double calculateProfit(LottoMoney lottoMoney) {
        long sum = result.keySet().stream()
                .mapToLong(rank -> rank.getPrize() * result.get(rank))
                .sum();

        return ((double) sum / lottoMoney.money()) * 100.0;
    }

    public int countOf(Rank rank) {
        return result.get(rank);
    }
}
