package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;

public interface OutputView {
    void printPurchasedLotto(LottoTickets lottoTickets);

    void printLottoStatistics(LottoStatistics lottoStatistics, double returnRate);

    void printInputAmountNotice();

    void printInputWinningLottoNotice();

    void printInputBonusNumberNotice();
}
