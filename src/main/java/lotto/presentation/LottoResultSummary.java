package lotto.presentation;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Prize;

public class LottoResultSummary {
    private final Map<Prize, Integer> prizes;
    private static final String MATCH_FORMAT = "%d개 일치";
    private static final String REWARD_FORMAT = " (%s원)";
    private static final String COUNT_FORMAT = " - %d개";
    private static final String BONUS_TEXT = ", 보너스 볼 일치";
    private static final String SEPARATOR = System.lineSeparator();

    public LottoResultSummary(List<Prize> winnings) {
        prizes = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
        winnings.forEach(prize -> prizes.put(prize, prizes.get(prize) + 1));
    }

    public String generateSummary() {
        return prizes.keySet().stream()
                .filter(integer -> integer != Prize.NONE) // NONE 제외
                .map(this::generatePrizeSummary)
                .collect(Collectors.joining(SEPARATOR));
    }

    private String generatePrizeSummary(Prize prize) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(MATCH_FORMAT, prize.getMatchCount()));

        if (prize == Prize.FIVE_BONUS) {
            stringBuilder.append(BONUS_TEXT);
        }

        stringBuilder.append(String.format(REWARD_FORMAT, String.format("%,d", prize.getReward())));
        stringBuilder.append(String.format(COUNT_FORMAT, prizes.get(prize)));
        return stringBuilder.toString();
    }
}
