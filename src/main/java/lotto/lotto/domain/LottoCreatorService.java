package lotto.lotto.domain;

public interface LottoCreatorService {
    LottoTickets createLottoTickets(int count);
    BonusNumber createBonusNumber(WinningLotto winningLotto);
    WinningLotto createWinningLotto();
}
