package lotto.view.impl;

import java.util.Map;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String NUMBER_OF_PURCHASE_LOTTO_NOTICE = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_STATISTICS_NOTICE = "\n당첨 통계\n---";
    private static final String NONE_BONUS_MATCHES_NOTICE = "%d개 일치 (%,d원) - %d개\n";
    private static final String BONUS_MATCHES_NOTICE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String RETURN_RATE_NOTICE = "총 수익률은 %.1f%%입니다.";
    private static final String INPUT_AMOUNT_NOTICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NOTICE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_NOTICE = "\n보너스 번호를 입력해 주세요.";

    @Override
    public void printPurchasedLotto(LottoTickets lottoTickets) {
        System.out.printf(NUMBER_OF_PURCHASE_LOTTO_NOTICE, lottoTickets.getLottoTickets().size());
        lottoTickets.getLottoTickets().stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    @Override
    public void printLottoStatistics(LottoStatistics lottoStatistics, double returnRate) {
        System.out.println(LOTTO_STATISTICS_NOTICE);
        Map<LottoRank, Integer> results = lottoStatistics.getResults();
        results.forEach(this::printLottoPrize);
        System.out.printf(RETURN_RATE_NOTICE, returnRate);
    }

    @Override
    public void printInputAmountNotice() {
        System.out.println(INPUT_AMOUNT_NOTICE);
    }

    @Override
    public void printInputWinningLottoNotice() {
        System.out.println(INPUT_WINNING_LOTTO_NOTICE);
    }

    @Override
    public void printInputBonusNumberNotice() {
        System.out.println(INPUT_BONUS_NUMBER_NOTICE);
    }

    private void printLottoPrize(LottoRank lottoRank, int count) {
        if (lottoRank == LottoRank.NONE) {
            return;
        }
        if (lottoRank.isMatchBonus()) {
            System.out.printf(BONUS_MATCHES_NOTICE, lottoRank.getMatchCount(), lottoRank.getPrize(), count);
            return;
        }
        System.out.printf(NONE_BONUS_MATCHES_NOTICE, lottoRank.getMatchCount(), lottoRank.getPrize(), count);
    }
}
