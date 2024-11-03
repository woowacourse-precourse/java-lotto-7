package lotto.service;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.domain.LottoTicket;

public class UserOutputService {
    private static final String CURRENCY_UNIT = "원";
    private static final String LOTTO_RESULT_BASIC = "%d개 일치 (%s) - %d개\n";
    private static final String LOTTO_RESULT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";

    private final Prompter prompter;

    public UserOutputService(Prompter prompter) {
        this.prompter = prompter;
    }

    public void printPurchasedLottoTicket(LottoTicket lottoTicket) {
        this.prompter.showOutputPurchaseCountPrompt(lottoTicket.size());
        this.prompter.showMessage(lottoTicket.toString());
    }

    public void printWinningStatistics(Map<String, Integer> winningLottos) {
        this.prompter.showOutputWinningStatisticsPrompt();
        String winningStatistics = getWinningStatistics(winningLottos);
        this.prompter.showMessage(winningStatistics);
    }

    private String getWinningStatistics(Map<String, Integer> winningLottos) {
        StringBuilder stringBuilder = new StringBuilder();
        LottoRank[] ranks = LottoRank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            LottoRank rank = ranks[i];
            int count = winningLottos.getOrDefault(rank.name(), 0);
            stringBuilder.append(formatLottoRank(rank, count));
        }
        return stringBuilder.toString();
    }

    private String formatLottoRank(LottoRank rank, int count) {
        if (rank.isCheckBonus()) {
            return String.format(LOTTO_RESULT_WITH_BONUS, rank.getMatchCount(), formatCurrency(rank.getPrizeMoney()), count);
        }
        return String.format(LOTTO_RESULT_BASIC, rank.getMatchCount(), formatCurrency(rank.getPrizeMoney()), count);
    }

    private String formatCurrency(int prizeMoney) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(prizeMoney) + CURRENCY_UNIT;
    }
}
