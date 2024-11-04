package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoProfitCalculator;
import lotto.domain.Rank;

public class LottoResultAnalysisService {

    private static final int INITIAL_STATISTICS_VALUE = 0;

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;
    private final LottoProfitCalculator lottoProfitCalculator;

    public LottoResultAnalysisService(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
        this.lottoProfitCalculator = new LottoProfitCalculator();
    }

    public List<Rank> generateWinningResults(List<Lotto> lottos) {
        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchedCount = countDuplicate(lotto);

            results.add(Rank.findByCountAndBonusNumber(matchedCount, hasBonusNumber(lotto)));
        }
        return results;
    }

    private int countDuplicate(Lotto lotto) {
        Set<Integer> uniqueWinningNumber = new HashSet<>(winningNumbers.getNumbers());
        int count = 0;

        for (int num : lotto.getNumbers()) {
            if (!uniqueWinningNumber.add(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.toInteger());
    }

    // TODO: payment를 wrapping.?
    public String getLottoProfitRate(List<Rank> winningResults, int payment) {
        BigDecimal profit = lottoProfitCalculator.getProfit(winningResults);
        BigDecimal profitRate = lottoProfitCalculator.getProfitRate(profit, payment);
        return profitRate.toPlainString();
    }

    public List<Integer> getWinningStatistics(List<Rank> ranks) {
        List<Integer> statistics = new ArrayList<>(Collections.nCopies(Rank.values().length, INITIAL_STATISTICS_VALUE));
        for (Rank rank : ranks) {
            int index = rank.getIndex();
            statistics.set(index, statistics.get(index) + 1);
        }
        return statistics;
    }
}
