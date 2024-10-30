package lotto;

import java.math.BigInteger;
import java.util.*;

public class WinningStatisticsManager {
    private List<Integer> statistics = new ArrayList<>(Collections.nCopies(5, 0));
    private LottoConverter converter = new LottoConverter();
    private WinningNumberChecker checker;
    private boolean containBonus;
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

    public PrizeTier getPrizeTier(int matchCount, boolean hasBonus) {
        for (PrizeTier tier : PrizeTier.values()) {
            if (tier.getMatchCount() == matchCount && (hasBonus ? 1 : 0) == tier.getBonusCount()) {
                return tier;
            }
        }
        return null;
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

    public void increaseThree(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==3)
            statistics.set(0, statistics.getFirst() + 1);
    }

    public void increaseFour(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==4)
            statistics.set(1, statistics.get(1) + 1);
    }

    public void increaseFive(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==5)
            statistics.set(2, statistics.get(2) + 1);
    }

    public void increaseFiveAndBonus(Lotto lotto,int bonusNumber){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==5&&containBonus)
            statistics.set(3, statistics.get(3) + 1);
    }

    public void increaseSix(Lotto lotto){
        if(checker.countMatchingNumbers(converter.LottoIntoNumber(lotto))==6)
            statistics.set(4, statistics.get(4) + 1);
    }

    public void increaseAll(Lotto lotto){
        increaseThree(lotto);
        increaseFour(lotto);
        increaseFive(lotto);
        increaseFiveAndBonus(lotto,checker.getBonusNumber());
        increaseSix(lotto);
    }

    public double getEaringRate(BigInteger money){
        BigInteger sum = BigInteger.ZERO;
        sum = sum.add(BigInteger.valueOf(5000).multiply(BigInteger.valueOf(statistics.getFirst())));
        sum = sum.add(BigInteger.valueOf(50000).multiply(BigInteger.valueOf(statistics.get(1))));
        sum = sum.add(BigInteger.valueOf(1500000).multiply(BigInteger.valueOf(statistics.get(2))));
        sum = sum.add(BigInteger.valueOf(30000000).multiply(BigInteger.valueOf(statistics.get(3))));
        sum = sum.add(BigInteger.valueOf(2000000000).multiply(BigInteger.valueOf(statistics.get(4))));
        return sum.divide(money).doubleValue();
    }

    public void setContainBonus(boolean doesContain){
        this.containBonus = doesContain;
    }
}
