package lotto.domain;

import java.util.*;

public class MatchCalculator {

    private final WinningNumber winningNumber;
    private final Lottos lottos;
    private Map<Prize, Integer> matchResult;
    private int prizeMoney;

    public MatchCalculator(WinningNumber winningNumber, Lottos lottos) {
        this.winningNumber = winningNumber;
        this.lottos = lottos;
        this.matchResult = new HashMap<>();
        this.prizeMoney = 0;
        initResult();
    }

    private void initResult() {
        for (Prize value : Prize.values()) {
            matchResult.put(value, 0);
        }
    }

    public void calculatePrize() {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningNumber.getWinningNumber();
            int matchCount = (int) numbers.stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean matchBonus = numbers.contains(winningNumber.getBonusNumber());

            Prize prize = determinePrize(matchCount, matchBonus);

            if (prize != null) {
                matchResult.put(prize, matchResult.get(prize) + 1);
            }
        }

    }

    private Prize determinePrize(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            if (matchBonus) {
                prizeMoney += Prize.SECOND.getPrizeMoney();
                return Prize.SECOND;
            }

            prizeMoney += Prize.THIRD.getPrizeMoney();
            return Prize.THIRD;
        }

        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == matchCount) {
                prizeMoney += prize.getPrizeMoney();
                return prize;
            }
        }
        return Prize.NOTHING;
    }

    public Map<Prize, Integer> getPrizes() {
        return Collections.unmodifiableMap(matchResult);
    }

    public double calculateEarnRate() {
        if (lottos.getPurchaseMoney() == 0) {
            return 0.0;
        }

        double rate = (double) prizeMoney / lottos.getPurchaseMoney() * 100;
        return Math.round(rate * 100) / 100.0;
    }
}
