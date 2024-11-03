package lotto.lotto.infrastructure;

import lotto.lotto.service.LottoGenerator;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.service.PurchaseLottoTickets;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.service.BonusNumberCreatorService;
import lotto.lotto.domain.WinningLotto;
import lotto.lotto.service.WinningLottoCreatorService;

public class LottoCreator implements LottoGenerator {
    private final PurchaseLottoTickets purchaseLottoTickets;
    private final BonusNumberCreatorService bonusNumberCreator;
    private final WinningLottoCreatorService winningLottoCreator;
    public LottoCreator(
            PurchaseLottoTickets purchaseLottoTickets,
            WinningLottoCreatorService winningLottoCreator,
            BonusNumberCreatorService bonusNumberCreator
    ) {
        this.purchaseLottoTickets = purchaseLottoTickets;
        this.winningLottoCreator = winningLottoCreator;
        this.bonusNumberCreator = bonusNumberCreator;
    }
    @Override
    public LottoTickets lottoTickets(int count) {
        return purchaseLottoTickets.purchase(count);
    }
    @Override
    public BonusNumber bonusNumber(WinningLotto winningLotto) {
        return bonusNumberCreator.create(winningLotto);
    }
    @Override
    public WinningLotto winningLotto() {
        return winningLottoCreator.create();
    }
}
