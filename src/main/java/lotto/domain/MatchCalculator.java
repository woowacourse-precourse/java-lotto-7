package lotto.domain;

import java.util.*;

public class MatchCalculator {

    private final WinningNumber winningNumber;
    private final Lottos lottos;
    private final Map<Prize, Integer> matchResult;
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
            matchResult.put(prize, matchResult.get(prize) + 1);
        }
    }

    private Prize determinePrize(int matchCount, boolean matchBonus) {
        Prize prize = Prize.findPrize(matchCount, matchBonus);
        prizeMoney += prize.getPrizeMoney();
        return prize;
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
