package lotto.domain;

import java.math.BigInteger;

public class LottoBuyer {
    private final BigInteger purchaseAmount;
    private final LottoTicket lottoTicket;

    public LottoBuyer(BigInteger purchaseAmount, LottoTicket lottoTicket) {
        this.purchaseAmount = purchaseAmount;
        this.lottoTicket = lottoTicket;
    }
}
