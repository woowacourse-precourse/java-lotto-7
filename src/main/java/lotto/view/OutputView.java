package lotto.view;

import static java.util.stream.Collectors.joining;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.WinningRank;

public class OutputView {

    private static final String LOTTIES_DELIMITER = "\n";
    private static final String LOTTO_DELIMITER = ", ";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";

    private static final String RESULT_TITLE = """
            
            당첨 통계
            ---""";
    private static final List<WinningRank> OUTPUT_ORDER = List.of(WinningRank.FIFTH_RANK,
            WinningRank.FOURTH_RANK, WinningRank.THIRD_RANK, WinningRank.SECOND_RANK, WinningRank.FIRST_RANK);
    private static final String RANK_DELIMITER = "\n";
    private static final DecimalFormat LONG_FORMATTER = new DecimalFormat("###,###");
    private static final long NOT_EXIST = 0;
    private static final DecimalFormat DOUBLE_FORMATTER = new DecimalFormat("###,##0.0");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void printLotties(List<List<Integer>> lotties) {
        System.out.println("\n" + lotties.size() + "개를 구매했습니다.");
        System.out.println(toLottiesFormat(lotties));
    }

    private static String toLottiesFormat(List<List<Integer>> lotties) {
        return lotties.stream()
                .map(OutputView::toLottoFormat)
                .collect(joining(LOTTIES_DELIMITER));
    }

    private static String toLottoFormat(List<Integer> lotto) {
        return lotto.stream()
                .map(Object::toString)
                .collect(joining(LOTTO_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX));
    }

    public static void printResult(Map<WinningRank, Long> result, double profit) {
        System.out.println(RESULT_TITLE);
        System.out.println(toResultFormat(result));
        System.out.println(toProfitFormat(profit));
    }

    private static String toResultFormat(Map<WinningRank, Long> result) {
        return OUTPUT_ORDER.stream()
                .map(rank -> toRankFormat(rank, result.getOrDefault(rank, NOT_EXIST)))
                .collect(joining(RANK_DELIMITER));
    }

    private static String toRankFormat(WinningRank rank, long count) {
        if (rank.isNeedBonusMatch()) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
                    .formatted(rank.getMatchCountLimit(), LONG_FORMATTER.format(rank.getWinningAmount()), count);
        }
        return "%d개 일치 (%s원) - %d개"
                .formatted(rank.getMatchCountLimit(), LONG_FORMATTER.format(rank.getWinningAmount()), count);
    }

    private static String toProfitFormat(double profit) {
        return "총 수익률은 %s%%입니다.".formatted(DOUBLE_FORMATTER.format(profit));
    }

    public static void printExceptionMessage(Exception exception) {
        System.out.println(ERROR_PREFIX + exception.getMessage());
    }
}
