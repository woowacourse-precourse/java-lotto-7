package lotto.io.output;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoWinningCriteria;

public class UserOutputService {
    private static final String CURRENCY_UNIT = "원";
    private static final String LOTTO_RESULT_BASIC = "%d개 일치 (%s) - %d개\n";
    private static final String LOTTO_RESULT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";

    private final UserPromptService userPromptService;

    public UserOutputService(UserPromptService userPromptService) {
        this.userPromptService = userPromptService;
    }

    public void printPurchasedLottoTicket(LottoTicket lottoTicket) {
        this.userPromptService.showOutputPurchaseCountPrompt(lottoTicket.size());
        this.userPromptService.showMessage(lottoTicket.toString());
    }

    public void printRateOfReturn(double rateOfReturn) {
        this.userPromptService.showRateOfReturnPrompt(rateOfReturn);
    }

    public void printWinningStatistics(Map<String, Integer> winningLottos) {
        this.userPromptService.showOutputWinningStatisticsPrompt();
        String winningStatistics = getWinningStatistics(winningLottos);
        this.userPromptService.showMessage(winningStatistics);
    }

    private String getWinningStatistics(Map<String, Integer> winningLottos) {
        StringBuilder stringBuilder = new StringBuilder();
        LottoWinningCriteria[] ranks = LottoWinningCriteria.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            LottoWinningCriteria rank = ranks[i];
            int count = winningLottos.getOrDefault(rank.name(), 0);
            stringBuilder.append(formatLottoRank(rank, count));
        }
        return stringBuilder.toString();
    }

    private String formatLottoRank(LottoWinningCriteria rank, int count) {
        if (rank.isCheckBonus()) {
            return String.format(LOTTO_RESULT_WITH_BONUS, rank.getMatchCount(), formatCurrency(rank.getPrizeMoney()),
                    count);
        }
        return String.format(LOTTO_RESULT_BASIC, rank.getMatchCount(), formatCurrency(rank.getPrizeMoney()), count);
    }

    private String formatCurrency(int prizeMoney) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(prizeMoney) + CURRENCY_UNIT;
    }
}
