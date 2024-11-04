package lotto.domain.matcher;

import lotto.domain.lotto.Lotto;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.LottoResult;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.lotto.WinningLotto;

public class LottoTicketMatcher {

    private final LottoResult lottoResult;

    public LottoTicketMatcher() {
        this.lottoResult = new LottoResult();
    }

    public LottoResult matchLottoTicket(LottoTicket purchasedLottoTicket, WinningLotto winningLotto) {
        for(Lotto purchasedLotto : purchasedLottoTicket.getLottoTicket()) {
            matchLotto(purchasedLotto, winningLotto);
        }
        return lottoResult;
    }

    private void matchLotto(Lotto purchasedLotto, WinningLotto winningLotto) {
        int matchCount = calculateMatchCount(purchasedLotto, winningLotto);
        boolean bonusNumberMatched = containsBonusNumber(purchasedLotto, winningLotto);
        LottoPrize lottoPrize = LottoPrize.getLottoPrize(matchCount, bonusNumberMatched);
        lottoResult.addLottoResult(lottoPrize);
    }

    private int calculateMatchCount(Lotto purchasedLotto, WinningLotto winningLotto) {
        return (int) purchasedLotto.getLottoNumbers()
                .stream()
                .filter(lottoNumber -> winningLotto.getWinningLotto().getLottoNumbers().contains(lottoNumber))
                .count();
    }

    private boolean containsBonusNumber(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getLottoNumbers()
                .stream()
                .anyMatch(lottoNumber -> winningLotto.getBonusNumber().equals(lottoNumber));
    }
}
