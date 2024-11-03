package lotto.service;

import java.math.BigInteger;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoSeller;
import lotto.domain.WinningLotto;

public class LottoRetailer {
    private final LottoSeller lottoSeller;

    public LottoRetailer(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public LottoBuyer sellAsMuchAs(BigInteger amount) {
        LottoTicket lottoTicket = lottoSeller.createLottoTicketFor(amount);
        return new LottoBuyer(amount, lottoTicket);
    }

    public WinningLotto createWinningLotto(List<Integer> numbers) {
        LottoTicket winningTicket = lottoSeller.createLottoTicketFor(numbers);
        return new WinningLotto(winningTicket);
    }
}
