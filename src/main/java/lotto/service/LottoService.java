package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.domain.WinningLotto;

public class LottoService {

    private Wallet wallet;
    private WinningLotto winningLotto;

    public void setupMoney(long money) {
        wallet = new Wallet(money);
    }

    public List<Lotto> buyTickets() {
        wallet.buyLottoTickets();
        return wallet.getTickets();
    }

    public void setupWinningNumbers(List<Integer> numbers, int bonusNumber) {
        winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);
    }

    public Wallet result() {
        wallet.getTickets().stream()
            .map((lotto) -> winningLotto.getRank(lotto))
            .forEach(rank -> wallet.addRank(rank));
        return wallet;
    }
}
