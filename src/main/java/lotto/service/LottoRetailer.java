package lotto.service;

import java.math.BigInteger;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoSeller;

public class LottoRetailer {
    private final LottoSeller lottoSeller;

    public LottoRetailer(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public LottoBuyer sellAsMuchAs(BigInteger amount) {
        LottoTicket lottoTicket = lottoSeller.createLottoTicketFor(amount);
        return new LottoBuyer(amount, lottoTicket);
    }

    public LottoTicket createWinningLotto(List<Integer> numbers) {
        return lottoSeller.createLottoTicketFor(numbers);
    }
}
