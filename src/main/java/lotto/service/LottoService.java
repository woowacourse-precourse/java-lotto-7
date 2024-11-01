package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.domain.WinningLotto;
import lotto.random.LottoRandom;
import lotto.random.LottoRandomStrategy;

public class LottoService {

    private Wallet wallet;
    private WinningLotto winningLotto;
    private final LottoRandom lottoRandom = new LottoRandomStrategy();

    public void setupMoney(long money) {
        wallet = new Wallet(money);
    }

    public List<Lotto> buyTickets() {
        wallet.buyLottoTickets(lottoRandom);
        return wallet.getTickets();
    }

    public void setupWinningNumbers(List<Integer> numbers) {
        winningLotto = new WinningLotto(new Lotto(numbers));
    }

    public void setupBonusNumber(int bonusNumber) {
        winningLotto.setupBonusNumber(bonusNumber);
    }

    public Wallet result() {
        wallet.getTickets().stream()
            .map((lotto) -> winningLotto.getRank(lotto))
            .forEach(rank -> wallet.addRank(rank));
        return wallet;
    }
}
