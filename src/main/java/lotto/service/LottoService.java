package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.domain.WinningLotto;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.MoneyRequest;
import lotto.dto.request.WinningNumbersRequest;
import lotto.random.LottoRandom;
import lotto.random.LottoRandomStrategy;
import lotto.repository.WalletRepository;
import lotto.repository.WinningLottoRepository;

public class LottoService {

    private final LottoRandom lottoRandom = new LottoRandomStrategy();
    private final WalletRepository walletRepository = new WalletRepository();
    private final WinningLottoRepository winningLottoRepository = new WinningLottoRepository();

    public void setupMoney(MoneyRequest request) {
        walletRepository.create(request.money());
    }

    public List<Lotto> buyLottos() {
        return walletRepository.buyLottos(lottoRandom);
    }

    public void setupWinningNumbers(WinningNumbersRequest request) {
        winningLottoRepository.createLotto(new Lotto(request.winningNumbers()));
    }

    public void setupBonusNumber(BonusNumberRequest request) {
        winningLottoRepository.createBonusNumber(request.bonusNumber());
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
