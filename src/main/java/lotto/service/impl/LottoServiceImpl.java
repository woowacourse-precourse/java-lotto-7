package lotto.service.impl;

import java.util.List;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {
    private final LottoMachine lottoMachine;

    public LottoServiceImpl(LottoMachine machine) {
        this.lottoMachine = machine;
    }

    @Override
    public LottoTickets purchaseTickets(int amount) {
        lottoMachine.insertAmount(amount);
        return lottoMachine.getLottoTickets();
    }

    @Override
    public WinningLotto createWinningNumbers(Lotto winningLotto, int bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    @Override
    public LottoStatistics collectResults(LottoTickets tickets, WinningLotto winningLotto) {
        LottoStatistics statistics = new LottoStatistics();
        for (Lotto ticket : tickets.getLottoTickets()) {
            LottoRank rank = winningLotto.determineRank(ticket);
            statistics.recordResult(rank);
        }
        return statistics;
    }

    @Override
    public double calculateProfitRate(LottoStatistics statistics) {
        return statistics.calculateProfitRate(lottoMachine.getInputAmount());
    }
}
