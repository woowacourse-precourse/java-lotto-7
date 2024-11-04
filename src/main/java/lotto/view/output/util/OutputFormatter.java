package lotto.view.output.util;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.vo.LottoRank;
import lotto.dto.response.PurchasedLottoDTO;
import lotto.dto.response.WinningResultDTO;

public final class OutputFormatter {
    private static final String PURCHASE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String RESULT_PREFIX = "당첨 통계\n---\n";
    private static final String WINNING_DESCRIPTION_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String WINNING_DESCRIPTION_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static String formatPurchaseLottoCount(Integer count) {
        return String.format(PURCHASE_LOTTO_COUNT_FORMAT, count);
    }

    public static String formatLottoNumbers(List<PurchasedLottoDTO> lottos) {
        return lottos.stream()
                .map(lotto -> lotto.numbers().toString())
                .collect(Collectors.joining(LINE_SEPARATOR)) + LINE_SEPARATOR;
    }

    public static String formatResultPrefix() {
        return RESULT_PREFIX;
    }

    public static String formatWinningResults(List<WinningResultDTO> results) {
        return results.stream()
                .map(dto -> formatWinningDescription(dto.rank(), dto.count()))
                .collect(Collectors.joining(LINE_SEPARATOR)) + LINE_SEPARATOR;
    }

    private static String formatWinningDescription(LottoRank rank, int winCount) {
        if (rank.isBonusMatch()) {
            return String.format(
                    WINNING_DESCRIPTION_WITH_BONUS_FORMAT,
                    rank.getMatchingCount(),
                    rank.getPrize(),
                    winCount
            );
        }
        return String.format(
                WINNING_DESCRIPTION_FORMAT,
                rank.getMatchingCount(),
                rank.getPrize(),
                winCount
        );
    }
}
