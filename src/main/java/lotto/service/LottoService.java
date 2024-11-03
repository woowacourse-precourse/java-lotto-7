package lotto.service;

import lotto.domain.Wallet;
import lotto.domain.WinningLotto;
import lotto.domain.lotto.Lotto;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.MoneyRequest;
import lotto.dto.request.WinningNumbersRequest;
import lotto.dto.response.LottosResponse;
import lotto.dto.response.ResultResponse;
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

    public LottosResponse buyLottos() {
        return LottosResponse.of(walletRepository.buyLottos(lottoRandom));
    }

    public void setupWinningNumbers(WinningNumbersRequest request) {
        winningLottoRepository.createLotto(new Lotto(request.winningNumbers()));
    }

    public void setupBonusNumber(BonusNumberRequest request) {
        winningLottoRepository.createBonusNumber(request.bonusNumber());
    }

    public ResultResponse result() {
        Wallet wallet = walletRepository.get();
        WinningLotto winningLotto = winningLottoRepository.get();
        wallet.getLottos().stream()
            .map(winningLotto::getRank)
            .forEach(wallet::addRank);

        return ResultResponse.of(wallet.getRanks(), wallet.gain());
    }
}
