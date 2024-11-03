package lotto.repository;

import java.util.List;

import lotto.domain.Wallet;
import lotto.domain.lotto.Lotto;
import lotto.random.LottoRandom;

public class WalletRepository {

    private Wallet wallet;

    public void create(long money) {
        wallet = new Wallet(money);
    }

    public List<Lotto> buyLottos(LottoRandom lottoRandom) {
        wallet.buyLottoTickets(lottoRandom);
        return wallet.getLottos();
    }

    public Wallet get() {
        return wallet;
    }
}
