package lotto.core.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.commons.util.Collections;
import lotto.core.enums.WinningRank;

public class LottoResult {

    private final LottoTicket ticket;

    private final List<WinningRank> winningRanks;

    public LottoResult(LottoTicket ticket, List<WinningRank> winningRanks) {
        this.ticket = ticket;
        this.winningRanks = winningRanks;
    }

    public LottoTicket getTicket() {
        return this.ticket;
    }

    public List<WinningRank> getWinningRanks() {
        return this.winningRanks;
    }

    public BigDecimal getRateOfReturn() {
        BigDecimal purchaseAmount = BigDecimal.valueOf(ticket.getAmount().getValue());
        BigDecimal totalWinningAmount = Collections.sumOf(this.winningRanks, WinningRank::getWinningAmount);
        return totalWinningAmount
                .divide(purchaseAmount, 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }
}
