package lotto.domain;

import static lotto.utils.Constant.DEFAULT_MATCH_COUNT_VALUE;
import static lotto.utils.Constant.LOTTO_WINNING_STATUS_MESSAGE;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.TreeMap;

public class LottoResult {
    private final Map<LottoRanking, Integer> result = new TreeMap<>(Collections.reverseOrder());

    public LottoResult() {
        for (LottoRanking rank : LottoRanking.values()) {
            result.put(rank, DEFAULT_MATCH_COUNT_VALUE);
        }
    }

    @Override
    public String toString() {
        StringJoiner lottoRankingResult = new StringJoiner("\n");

        for (Entry<LottoRanking, Integer> entry : result.entrySet()) {
            LottoRanking rank = entry.getKey();
            int matchCount = entry.getValue();

            if (rank != LottoRanking.NOTHING) {
                lottoRankingResult.add(String.format(LOTTO_WINNING_STATUS_MESSAGE, rank.getStatus(), matchCount));
            }
        }

        return lottoRankingResult.toString();
    }

    public void addMatchCount(LottoRanking rank) {
        result.put(rank, result.getOrDefault(rank, DEFAULT_MATCH_COUNT_VALUE) + 1);
    }

    public LottoRanking findRanking(int matchCount, boolean checkBonusNumber) {
        for (LottoRanking rank : LottoRanking.values()) {
            if (rank.isMatchRanking(matchCount, checkBonusNumber)) {
                return rank;
            }
        }

        return LottoRanking.NOTHING;
    }

    public double calculatePrize(int purchaseAmount) {
        double totalPrize = 0.0;
        for (LottoRanking rank : LottoRanking.values()) {
            totalPrize += (rank.getPrize() * result.get(rank));
        }

        return totalPrize / purchaseAmount * 100;
    }
}
