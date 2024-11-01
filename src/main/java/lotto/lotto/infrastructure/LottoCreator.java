package lotto.lotto.service;

import lotto.lotto.domain.LottoTickets;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;
import lotto.lotto.winning.infrastructure.BonusNumberCreator;
import lotto.lotto.winning.infrastructure.WinningLottoCreator;

public class LottoCreator {
    private final LottoTicketsCreator lottoTicketsCreator;
    private final BonusNumberCreator bonusNumberCreator;
    private final WinningLottoCreator winningLottoCreator;
    public LottoCreator(
            LottoTicketsCreator lottoTicketsCreator,
            WinningLottoCreator winningLottoCreator,
            BonusNumberCreator bonusNumberCreator
    ) {
        this.lottoTicketsCreator = lottoTicketsCreator;
        this.winningLottoCreator = winningLottoCreator;
        this.bonusNumberCreator = bonusNumberCreator;
    }
    public LottoTickets createLottoTickets(int count) {
        return lottoTicketsCreator.purchaseLottoTickets(count);
    }
    public BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return bonusNumberCreator.create(winningLotto);
    }
    public WinningLotto createWinningLotto() {
        return winningLottoCreator.create();
    }
}
