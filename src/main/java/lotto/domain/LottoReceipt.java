package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class LottoReceipt {
    private final BigInteger totalAmount;
    private final LottoTicket issuedTicket;

    public LottoReceipt(BigInteger totalAmount, LottoTicket issuedTicket) {
        this.totalAmount = totalAmount;
        this.issuedTicket = issuedTicket;
    }

    public List<Winning> checkWinningsWith(WinningLotto winningLotto) {
        return issuedTicket.lottos().stream()
                .map(winningLotto::checkWinningWith)
                .toList();
    }

    public BigDecimal calculateRateOfReturn(BigInteger totalPrize) {
        BigDecimal scaledTotalPrize = new BigDecimal(totalPrize).scaleByPowerOfTen(2);
        return scaledTotalPrize.divide(new BigDecimal(totalAmount), 1, RoundingMode.HALF_UP);
    }

    public BigInteger getIssuedLottoQuantity() {
        return BigInteger.valueOf(issuedTicket.lottos().size());
    }
}
