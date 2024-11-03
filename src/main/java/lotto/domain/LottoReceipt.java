package lotto.domain;

import java.math.BigInteger;
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
}
