package lotto.utils;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Result;

public class OutputHandler {

    private static final String RANK_FORMAT_START = "%d개 일치";
    private static final String BONUS_NUMBER_FORMAT = ", 보너스 볼 일치";
    private static final String RANK_FORMAT_END = " (%,d원) - %d개\n";

    public static int formatPurchaseLottosCount(Lottos lottos) {
        return lottos.getTicketCount();
    }

    public static String formatLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        lottos.getLottos().forEach(lotto -> sb.append(formatLotto(lotto)).append("\n"));
        return sb.toString();
    }

    private static String formatLotto(Lotto lotto) {
        return lotto.getNumbers().toString();
    }

    public static String formatResult(Result result) {
        StringBuilder sb = new StringBuilder();
        result.getResult().forEach((rank, count) -> sb.append(formatRank(rank, count)));
        return sb.toString();
    }

    private static String formatRank(Rank rank, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(RANK_FORMAT_START);
        if (rank.getHasBonusNumber()) {
            sb.append(BONUS_NUMBER_FORMAT);
        }
        sb.append(RANK_FORMAT_END);
        return String.format(sb.toString(), rank.getMatchingNumbersCount(), rank.getPrize(), count);
    }

    public static float formatRateOfReturn(Result result) {
        return result.getRateOfReturn();
    }
}
