package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public enum OutputMessage {
    SHOW_PURCHASE_COUNT("%d개를 구매했습니다."),
    SHOW_STATISTICS_INTRO("당첨 통계"),
    SHOW_SEPARATOR_LINE("---"),
    SHOW_MATCH_RESULT("%d개 일치 (%,d원) - %d개"),
    SHOW_MATCH_RESULT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    SHOW_TOTAL_PROFIT("총 수익률은 %.2f입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String makeResultFormat(Map<Rank, Integer> result) {
        StringBuilder sb = new StringBuilder();
        reversedRank(result)
                .forEach(rank -> makeEachResultFormat(sb, rank, result.get(rank)));
        return sb.toString();
    }

    private static List<Rank> reversedRank(Map<Rank, Integer> result) {
        return result.keySet().stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    private static void makeEachResultFormat(StringBuilder sb, Rank rank, int count) {
        if (rank.equals(Rank.NO_RANK)) {
            return;
        }

        String resultFormat = SHOW_MATCH_RESULT.getMessage();
        if (rank.getBonusMatch()) {
            resultFormat = SHOW_MATCH_RESULT_WITH_BONUS.getMessage();
        }

        sb.append(String.format(resultFormat, rank.getMatchCount(), rank.getPrize(), count));
        sb.append(System.lineSeparator());
    }
}
