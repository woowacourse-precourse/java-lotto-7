package lotto.domain;

import java.util.*;

public class MatchCalculator {

    private final WinningNumber winningNumber;
    private final List<Lotto> lottos;
    private Map<Prize, Integer> matchResult;

    public MatchCalculator(WinningNumber winningNumber, List<Lotto> lottos) {
        this.winningNumber = winningNumber;
        this.lottos = lottos;
        this.matchResult = new HashMap<>();
        initResult();
    }

    private void initResult() {
        for (Prize value : Prize.values()) {
            matchResult.put(value, 0);
        }
    }

    public void calculatePrize() {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            SequencedSet<Integer> winningNumbers = winningNumber.getWinningNumber();
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
                return Prize.SECOND;
            }
            return Prize.THIRD;
        }

        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return Prize.NOTHING;
    }

    public Map<Prize, Integer> getPrizes() {
        return Collections.unmodifiableMap(matchResult);
    }
}
