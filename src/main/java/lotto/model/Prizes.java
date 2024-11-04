package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.StringJoiner;

public class Prizes {
    final Map<Prize, Integer> prizes = new EnumMap<>(Prize.class);

    public void addPrize(Prize p) {
        prizes.put(p, prizes.getOrDefault(p, 0) + 1);
    }

    public String formatDescriptions() {
        StringJoiner stringJoiner = new StringJoiner("", "\n", "");

        for (Prize p : Prize.values()) {
            if (p != Prize.SIXTH) {
                stringJoiner.add(p.formatDescription(p, prizes.getOrDefault(p, 0)));
            }
        }

        return stringJoiner.toString();
    }

    public void sumRewards(Yield yield) {
        for (Prize p : prizes.keySet()) {
            p.sumReward(yield, prizes.get(p));
        }
    }

    public String formatYieldRatio(Yield yield) {
        return String.format("총 수익률은 %.1f%%입니다.\n", yield.calculateRatio());
    }
}
