package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.controller.LottoNumberGenerator;
import lotto.enums.LottoRank;

public class LottoService {
    private Map<LottoRank, Integer> matchResults;
    private final int lottoSetCount;
    private List<List<Integer>> lottoSets;
    private final int lottoMoney;

    public LottoService(int lottoMoney) {
        this.lottoSetCount = calculateLottoSetCount(lottoMoney);
        this.lottoMoney = lottoMoney;
        initializeMatchResults();
    }

    private void initializeMatchResults() {
        matchResults = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            matchResults.put(rank, 0);
        }
    }

    public void generateLottoSet() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        lottoSets = generator.generateLottoSet(lottoSetCount);
    }

    public List<List<Integer>> getLottoSets() {
        return lottoSets;
    }

    public void compareWinningNumbers(List<List<Integer>> lottoSets, List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);

        for (List<Integer> lottoNumber : lottoSets) {
            int matchCount = lotto.countMatchingNumbers(lottoNumber);
            boolean bonusMatch = lotto.containsBonusNumber(bonusNumber, lottoNumber);
            updateMatchResults(matchCount, bonusMatch);
        }
    }
    private void updateMatchResults(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (matchCount == rank.getMatchingCount() &&
                    (!rank.isBonusRequired() || (rank.isBonusRequired() && bonusMatch))) {
                matchResults.put(rank, matchResults.getOrDefault(rank, 0) + 1);
                return;
            }
        }
    }

    public Map<LottoRank, Integer> getMatchResults() {
        return matchResults;
    }

    public int calculateTotalEarnings() {
        int earnings = 0;

        for (LottoRank rank : LottoRank.values()) {
            earnings += matchResults.getOrDefault(rank, 0) * rank.getPrize();
        }

        return earnings;
    }

    public double calculateProfitRate() {
        int totalSpent = lottoMoney;
        int totalEarnings = calculateTotalEarnings();

        if (totalSpent == 0) {
            return 0;
        }

        double profitRate = (double) totalEarnings / totalSpent * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

    private int calculateLottoSetCount(int lottoMoney) {
        return lottoMoney / 1000;
    }
}