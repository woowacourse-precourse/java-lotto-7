package lotto.view.impl;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String NUMBER_OF_PURCHASE_LOTTO_NOTICE = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_STATISTICS_NOTICE = "\n당첨 통계\n---";
    private static final String RETURN_RATE_NOTICE = "총 수익률은 %.1f%%입니다.";
    private static final String INPUT_AMOUNT_NOTICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NOTICE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_NOTICE = "\n보너스 번호를 입력해 주세요.";

    @Override
    public void printBuyingLotto(LottoTickets lottoTickets) {
        System.out.printf(NUMBER_OF_PURCHASE_LOTTO_NOTICE, lottoTickets.getLottoTickets().size());
        lottoTickets.getLottoTickets().stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    @Override
    public void printLottoStatistics(LottoStatistics lottoStatistics, double returnRate) {
        System.out.println(LOTTO_STATISTICS_NOTICE);
        System.out.println(lottoStatistics.getResults());
        System.out.printf(RETURN_RATE_NOTICE, returnRate);
    }

    @Override
    public void printInputAmount() {
        System.out.println(INPUT_AMOUNT_NOTICE);
    }

    @Override
    public void printInputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_NOTICE);
    }

    @Override
    public void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_NOTICE);
    }
}
