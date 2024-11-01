package lotto.lotto.infrastructure;

import lotto.lotto.domain.LottoCreatorService;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.PurchaseLottoTicketsService;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.BonusNumberCreatorService;
import lotto.lotto.domain.WinningLotto;
import lotto.lotto.domain.WinningLottoCreatorService;

public class LottoCreator implements LottoCreatorService {
    private final PurchaseLottoTicketsService purchaseLottoTickets;
    private final BonusNumberCreatorService bonusNumberCreator;
    private final WinningLottoCreatorService winningLottoCreator;
    public LottoCreator(
            PurchaseLottoTicketsService purchaseLottoTickets,
            WinningLottoCreatorService winningLottoCreator,
            BonusNumberCreatorService bonusNumberCreator
    ) {
        this.purchaseLottoTickets = purchaseLottoTickets;
        this.winningLottoCreator = winningLottoCreator;
        this.bonusNumberCreator = bonusNumberCreator;
    }
    @Override
    public LottoTickets createLottoTickets(int count) {
        return purchaseLottoTickets.purchase(count);
    }
    @Override
    public BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return bonusNumberCreator.create(winningLotto);
    }
    @Override
    public WinningLotto createWinningLotto() {
        return winningLottoCreator.create();
    }
}
