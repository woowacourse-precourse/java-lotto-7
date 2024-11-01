package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;

public interface OutputView {
    void printBuyingLotto(LottoTickets lottoTickets);
    void printLottoStatistics(LottoStatistics lottoStatistics, double returnRate);
    void printInputAmount();
    void printInputWinningLotto();
    void printInputBonusNumber();
}
