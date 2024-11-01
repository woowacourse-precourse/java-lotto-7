package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;

public interface LottoService {
    LottoTickets purchaseTickets(int amount);

    WinningLotto createWinningNumbers(Lotto winningLotto, int bonusNumber);

    LottoStatistics collectResults(LottoTickets tickets, WinningLotto winningNumbers);

    double calculateProfitRate(LottoStatistics result);
}
