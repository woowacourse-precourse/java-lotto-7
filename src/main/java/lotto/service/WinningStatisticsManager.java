package lotto.service;

import lotto.Lotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class WinningStatisticsManager {
    private final List<Integer> statistics = new ArrayList<>(Collections.nCopies(5, 0));
    private final LottoConverter converter = new LottoConverter();
    private final WinningNumberChecker checker;

    public enum PrizeTier {
        FIFTH(3, 0, BigInteger.valueOf(5_000)),
        FOURTH(4, 0, BigInteger.valueOf(50_000)),
        THIRD(5, 0, BigInteger.valueOf(1_500_000)),
        SECOND(5, 1, BigInteger.valueOf(30_000_000)),
        FIRST(6, 0, BigInteger.valueOf(2_000_000_000));
        
        private final int matchCount;
        private final int bonusCount;
        private final BigInteger prize;

        PrizeTier(int matchCount, int bonusCount, BigInteger prize) {
            this.matchCount = matchCount;
            this.bonusCount = bonusCount;
            this.prize = prize;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getBonusCount() {
            return bonusCount;
        }

        public BigInteger getPrize() {
            return prize;
        }
    }

    public WinningStatisticsManager(WinningNumberChecker winningNumberChecker){
        this.checker = winningNumberChecker;
    }

    public Map<PrizeTier, Integer> getWinningStatistics() {
        Map<PrizeTier, Integer> winningStatistics = new HashMap<>();
        winningStatistics.put(PrizeTier.FIFTH, statistics.get(0)); // 3개 일치
        winningStatistics.put(PrizeTier.FOURTH, statistics.get(1)); // 4개 일치
        winningStatistics.put(PrizeTier.THIRD, statistics.get(2)); // 5개 일치
        winningStatistics.put(PrizeTier.SECOND, statistics.get(3)); // 5개 일치 + 보너스
        winningStatistics.put(PrizeTier.FIRST, statistics.get(4)); // 6개 일치
        return winningStatistics;
    }

    public WinningStatisticsManager increaseThree(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==3)
            statistics.set(0, statistics.getFirst() + 1);
        return this;
    }

    public WinningStatisticsManager increaseFour(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==4)
            statistics.set(1, statistics.get(1) + 1);
        return this;
    }

    public WinningStatisticsManager increaseFiveAndBonus(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==5&&checker.doesContainBonusNumber(lotto))
            statistics.set(3, statistics.get(3) + 1);
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==5&&!checker.doesContainBonusNumber(lotto))
            statistics.set(2, statistics.get(2) + 1);
        return this;
    }

    public WinningStatisticsManager increaseSix(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==6)
            statistics.set(4, statistics.get(4) + 1);
        return this;
    }

    public WinningStatisticsManager increaseAll(Lotto lotto){
        increaseThree(lotto);
        increaseFour(lotto);
        increaseFiveAndBonus(lotto);
        increaseSix(lotto);
        return this;
    }

    public BigDecimal getEarningRate(BigInteger money) {
        BigDecimal sum = BigDecimal.ZERO;
        sum = sum.add(BigDecimal.valueOf(5000).multiply(BigDecimal.valueOf(statistics.getFirst())));
        sum = sum.add(BigDecimal.valueOf(50000).multiply(BigDecimal.valueOf(statistics.get(1))));
        sum = sum.add(BigDecimal.valueOf(1500000).multiply(BigDecimal.valueOf(statistics.get(2))));
        sum = sum.add(BigDecimal.valueOf(30000000).multiply(BigDecimal.valueOf(statistics.get(3))));
        sum = sum.add(BigDecimal.valueOf(2000000000).multiply(BigDecimal.valueOf(statistics.get(4))));
        BigDecimal moneyDecimal = new BigDecimal(money);
        return sum.divide(moneyDecimal, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP); // doubleValue() 제거하여 BigDecimal 반환
    }
}
