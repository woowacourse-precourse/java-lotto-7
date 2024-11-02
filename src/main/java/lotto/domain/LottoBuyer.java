package lotto.domain;

import java.math.BigInteger;
import java.util.List;
import lotto.WinningLotto;

public class LottoBuyer {
    private final BigInteger purchaseAmount;
    private final LottoTicket purchasedTicket;

    public LottoBuyer(BigInteger purchaseAmount, LottoTicket purchasedTicket) {
        this.purchaseAmount = purchaseAmount;
        this.purchasedTicket = purchasedTicket;
    }

    public List<Integer> compareTo(WinningLotto winningLotto) {
        return purchasedTicket.lottos().stream()
                .map(winningLotto::countMatchingNumbersWith)
                .toList();
    }
}
