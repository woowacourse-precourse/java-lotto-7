package lotto.service;

import java.util.List;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;

public interface LottoService {
    LottoTickets purchaseTickets(int amount);

    WinningLotto createWinningNumbers(List<Integer> winningNumbers, int bonusNumber);

    LottoStatistics checkResults(LottoTickets tickets, WinningLotto winningNumbers);

    double calculateProfitRate(LottoStatistics result);
}
