package lotto.temp;

import lotto.model.LottoGenerator;
import lotto.model.RankCalculator;
import lotto.model.WinningNumberGenerator;
import lotto.service.TicketService;

public class LottoComponent {
    private final TicketService ticketService;
    private final LottoGenerator lottoGenerator;
    private final RankCalculator rankCalculator;
    private final WinningNumberGenerator winningNumberGenerator;

    public LottoComponent(TicketService ticketService, LottoGenerator lottoGenerator,
                          RankCalculator rankCalculator, WinningNumberGenerator winningNumberGenerator) {
        this.ticketService = ticketService;
        this.lottoGenerator = lottoGenerator;
        this.rankCalculator = rankCalculator;
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public TicketService getTicketService() {
        return ticketService;
    }

    public LottoGenerator getLottoGenerator() {
        return lottoGenerator;
    }

    public RankCalculator getRankCalculator() {
        return rankCalculator;
    }

    public WinningNumberGenerator getWinningNumberGenerator() {
        return winningNumberGenerator;
    }
}
