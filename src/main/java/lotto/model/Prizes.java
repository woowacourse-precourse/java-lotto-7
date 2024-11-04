package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class Prizes {
    final Map<Prize, Integer> prizes = new EnumMap<>(Prize.class);

    public void addPrize(Prize p) {
        prizes.put(p, prizes.getOrDefault(p, 0) + 1);
    }

    public String formatDescriptions() {
        String descriptions = "";

        for (Prize p : Prize.values()) {
            if (p != Prize.SIXTH) {
                descriptions += p.formatDescription(p, prizes.getOrDefault(p, 0));
            }
        }

        return descriptions;
    }

    public String formatYield(Integer amount) {
        String yield = "";

        for (Prize p : Prize.values()) {
            if (p != Prize.SIXTH) {

            }
        }
    }
}
