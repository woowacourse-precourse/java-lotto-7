package lotto.function.winning.register.processor;

import lotto.domain.WinningLotto;
import lotto.repository.WinningLottoRepository;

public class WinningLottoSaveProcessor {

    private final WinningLottoRepository winningLottoRepository;

    public WinningLottoSaveProcessor(
            WinningLottoRepository winningLottoRepository
    ) {
        this.winningLottoRepository = winningLottoRepository;
    }

    public void saveWinningLotto(WinningLotto winningLotto) {
        winningLottoRepository.save(winningLotto);
    }

}
