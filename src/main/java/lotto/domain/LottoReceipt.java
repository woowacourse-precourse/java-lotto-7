package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class LottoReceipt {
    private final BigInteger purchaseAmount;
    private final LottoTicket purchasedTicket;

    public LottoReceipt(BigInteger purchaseAmount, LottoTicket purchasedTicket) {
        this.purchaseAmount = purchaseAmount;
        this.purchasedTicket = purchasedTicket;
    }

    public List<Winning> checkWinningsBy(WinningLotto winningLotto) {
        List<Integer> totalMatchingNumbers = compareTo(winningLotto);
        return Winning.tellWinningBy(totalMatchingNumbers);
    }

    private List<Integer> compareTo(WinningLotto winningLotto) {
        return purchasedTicket.lottos().stream()
                .map(winningLotto::countMatchingNumbersWith)
                .toList();
    }

    public BigDecimal calculateRateOfReturn(BigInteger totalPrize) {
        BigDecimal scaledTotalPrize = new BigDecimal(totalPrize).scaleByPowerOfTen(2);
        return scaledTotalPrize.divide(new BigDecimal(purchaseAmount), 1, RoundingMode.HALF_UP);
    }
}
