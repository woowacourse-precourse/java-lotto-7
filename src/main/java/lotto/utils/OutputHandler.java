package lotto.utils;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Result;

public class OutputHandler {

    private static final String RANK_DEFAULT_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String RANK_BONUS_NUMBER_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String ENTER = "\n";

    public static int getCount(Lottos lottos) {
        return lottos.size();
    }

    public static String formatLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        lottos.getLottos().forEach(lotto -> sb.append(formatLotto(lotto)).append(ENTER));
        return sb.toString();
    }

    private static String formatLotto(Lotto lotto) {
        return lotto.getNumbers().toString();
    }

    public static String formatStatistics(Result result) {
        StringBuilder sb = new StringBuilder();
        result.getResult().forEach((rank, count) -> sb.append(formatRank(rank, count)).append(ENTER));
        return sb.toString();
    }

    private static String formatRank(Rank rank, int count) {
        if (rank.hasBonusNumber()) {
            return String.format(RANK_BONUS_NUMBER_FORMAT, rank.getMatchingNumber(), rank.getPrize(), count);
        }
        return String.format(RANK_DEFAULT_FORMAT, rank.getMatchingNumber(), rank.getPrize(), count);
    }

    public static float getRateOfReturn(Result result) {
        return result.getRateOfReturn();
    }
}
