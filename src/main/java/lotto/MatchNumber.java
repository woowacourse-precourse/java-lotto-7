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
        this.prizeCount = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void checkWinNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                .filter(num -> Arrays.stream(winNumber.getNumbers()).anyMatch(n -> n == num))
                .count();

            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            Prize prize = getPrizeByMatch(matchCount, matchBonus);
            if (prize != null) {
                prizeCount.put(prize, prizeCount.get(prize) + 1);
                totalPrize += prize.getPrizeAmount();
            }
        }
    }

    private Prize getPrizeByMatch(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return Prize.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return Prize.SECOND;
        }
        if (matchCount == 5) {
            return Prize.THIRD;
        }
        if (matchCount == 4) {
            return Prize.FOURTH;
        }
        if (matchCount == 3) {
            return Prize.FIFTH;
        }
        return null;
    }

    public Map<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
