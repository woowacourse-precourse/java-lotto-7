package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MatchNumber {

    private final WinNumber winNumber;
    private final int bonusNumber;
    private final Map<Prize, Integer> prizeCount;
    private int totalPrize = 0;

    public MatchNumber(WinNumber winNumber, int bonusNumber) {
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
        this.prizeCount = initializePrizeCount();
    }

    private Map<Prize, Integer> initializePrizeCount() {
        Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        return prizeCount;
    }

    public void checkWinNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Prize prize = getPrizeForLotto(lotto);
            if (prize != null) {
                incrementPrizeCount(prize);
                addPrizeAmount(prize);
            }
        }
    }

    private Prize getPrizeForLotto(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto);
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return determinePrize(matchCount, matchBonus);
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
            .filter(num -> Arrays.stream(winNumber.getNumbers()).anyMatch(n -> n == num))
            .count();
    }

    private Prize determinePrize(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return Prize.FIRST;
        if (matchCount == 5 && matchBonus) return Prize.SECOND;
        if (matchCount == 5) return Prize.THIRD;
        if (matchCount == 4) return Prize.FOURTH;
        if (matchCount == 3) return Prize.FIFTH;
        return null;
    }

    private void incrementPrizeCount(Prize prize) {
        prizeCount.put(prize, prizeCount.get(prize) + 1);
    }

    private void addPrizeAmount(Prize prize) {
        totalPrize += prize.getPrizeAmount();
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
