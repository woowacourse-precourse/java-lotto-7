package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.common.Displayable;
import lotto.common.SystemMessage;

public class Result implements Displayable {
    private static final String LINE_BREAK = "\n";
    private static final int LOTTO_PRICE = 1000;
    private static final String RESULT_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private final Map<Rank, Integer> ranks = new EnumMap<>(Rank.class);

    public Result(Map<Rank, Integer> ranks) {
        for (Rank rank : Rank.values()) {
            this.ranks.put(rank, ranks.getOrDefault(rank, 0));
        }
    }

    @Override
    public String toPrettyString() {
        return LINE_BREAK + SystemMessage.WINNING_STATISTICS.toPrettyString()
                + LINE_BREAK + getFormattedMessage()
                + LINE_BREAK + String.format(RESULT_MESSAGE_FORMAT, getProfit());

    }

    private String getFormattedMessage() {
        return ranks.entrySet().stream()
                .filter(e -> !e.getKey().equals(Rank.NONE))
                .map(entry -> {
                    Rank rank = entry.getKey();
                    Integer count = entry.getValue();
                    return rank.createMessage(count);
                })
                .collect(Collectors.joining(LINE_BREAK));
    }

    private float getProfit() {
        int totalCount = getTotalCount();
        int totalPrize = getTotalPrize();
        float profit = ((float) totalPrize / (totalCount * LOTTO_PRICE));
        return (float) Math.round(profit * 1000) / 10;//소숫점 둘째자리에서 반올림
    }


    private int getTotalCount() {
        return ranks.values().stream()
                .mapToInt(value -> value)
                .sum();
    }

    private int getTotalPrize() {
        return ranks.entrySet().stream()
                .mapToInt(entry -> {
                    Rank rank = entry.getKey();
                    Integer count = entry.getValue();
                    return rank.getPrize() * count;
                })
                .sum();
    }
}
