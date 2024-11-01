package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.domain.WinningLotto;
import lotto.random.LottoRandom;
import lotto.random.LottoRandomStrategy;
import lotto.repository.WalletRepository;
import lotto.repository.WinningLottoRepository;

public class LottoService {

    private final LottoRandom lottoRandom = new LottoRandomStrategy();
    private final WalletRepository walletRepository = new WalletRepository();
    private final WinningLottoRepository winningLottoRepository = new WinningLottoRepository();

    public void setupMoney(long money) {
        walletRepository.create(money);
    }

    public List<Lotto> buyLottos() {
        return walletRepository.buyLottos(lottoRandom);
    }

    public void setupWinningNumbers(List<Integer> numbers) {
        winningLottoRepository.createLotto(new Lotto(numbers));
    }

    public void setupBonusNumber(int bonusNumber) {
        winningLottoRepository.createBonusNumber(bonusNumber);
    }

    public Wallet result() {
        Wallet wallet = walletRepository.get();
        WinningLotto winningLotto = winningLottoRepository.get();
        wallet.getLottos().stream()
            .map(winningLotto::getRank)
            .forEach(wallet::addRank);
        return wallet;
    }
}
