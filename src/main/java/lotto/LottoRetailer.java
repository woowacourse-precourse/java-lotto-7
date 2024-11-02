package lotto;

import java.math.BigInteger;

public class LottoRetailer {
    private final LottoSeller lottoSeller;

    public LottoRetailer(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public LottoBuyer sellAsMuchAs(BigInteger amount) {
        LottoTicket lottoTicket = lottoSeller.createLottoTicketFor(amount);
        return new LottoBuyer(amount, lottoTicket);
    }
}
