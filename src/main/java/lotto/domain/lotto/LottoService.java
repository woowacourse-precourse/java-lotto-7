package lotto.domain.lotto;

import lotto.domain.matcher.LottoTicketMatcher;
import lotto.domain.prize.LottoResult;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketCreator;

public class LottoService {

    private final LottoTicketCreator lottoTicketCreator;
    private final LottoTicketMatcher lottoTicketMatcher;

    public LottoService(LottoTicketCreator lottoTicketCreator, LottoTicketMatcher lottoTicketMatcher) {
        this.lottoTicketCreator = lottoTicketCreator;
        this.lottoTicketMatcher = lottoTicketMatcher;
    }

    public LottoTicket generateLottoTicket(int lottoCount) {
        return lottoTicketCreator.createLottoTicket(lottoCount);
    }

    public LottoResult matchLottoTicket(LottoTicket purchasedLottoTicket, WinningLotto winningLotto) {
        return lottoTicketMatcher.matchLottoTicket(purchasedLottoTicket, winningLotto);
    }
}
