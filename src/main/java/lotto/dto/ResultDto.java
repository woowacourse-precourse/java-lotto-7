package lotto.dto;

import static lotto.message.SystemMessage.WINNING_RESULT_FORMAT;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public class ResultDto {

    private static final String PRIZE_NUMBER_FORMAT = "###,###";

    private final List<String> results;

    private ResultDto(Map<Rank, Integer> ranks) {
        results = Arrays.stream(Rank.values())
                .map(rank -> formatedResults(rank, ranks.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
    }

    public static ResultDto toDto(Map<Rank, Integer> ranks) {
        return new ResultDto(ranks);
    }

    public String toResults() {
        return String.join("\n", results);
    }

    private String formatedResults(Rank rank, int count) {
        String prize = convertPrizeFormat(rank.getPrize());
        return WINNING_RESULT_FORMAT.getMessage().formatted(rank.getMessage(), prize, count);
    }

    private String convertPrizeFormat(Integer prize) {
        return new DecimalFormat(PRIZE_NUMBER_FORMAT).format(prize);
    }

}
