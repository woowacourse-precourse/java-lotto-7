package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.player.Player;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.MoneyRequest;
import lotto.dto.request.WinningNumbersRequest;
import lotto.dto.response.LottosResponse;
import lotto.dto.response.ResultResponse;
import lotto.random.LottoRandom;
import lotto.random.LottoRandomStrategy;
import lotto.repository.PlayerRepository;
import lotto.repository.WinningLottoRepository;

public class LottoService {

    private final LottoRandom lottoRandom = new LottoRandomStrategy();
    private final PlayerRepository playerRepository = new PlayerRepository();
    private final WinningLottoRepository winningLottoRepository = new WinningLottoRepository();

    public void setupMoney(MoneyRequest request) {
        Player player = playerRepository.get();
        playerRepository.addMoney(request.money());
    }

    public LottosResponse buyLottos() {
        return LottosResponse.of(playerRepository.buyLottos(lottoRandom));
    }

    public void setupWinningNumbers(WinningNumbersRequest request) {
        winningLottoRepository.createLotto(new Lotto(request.winningNumbers()));
    }

    public void setupBonusNumber(BonusNumberRequest request) {
        winningLottoRepository.createBonusNumber(request.bonusNumber());
    }

    public ResultResponse result() {
        Player player = playerRepository.get();
        WinningLotto winningLotto = winningLottoRepository.get();
        player.getLottos().stream()
            .map(winningLotto::getRank)
            .forEach(player::addRank);

        return ResultResponse.of(player.getRanks(), player.gain());
    }
}
