package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.WinnerLotto;
import lotto.repository.SingleRepository;

public class WinnerLottoRepository implements SingleRepository<WinnerLotto> {

    private WinnerLotto winnerLotto;

    @Override
    public WinnerLotto save(WinnerLotto winnerLotto) {
        this.winnerLotto = winnerLotto;
        return this.winnerLotto;
    }

    @Override
    public Optional<WinnerLotto> get() {
        return Optional.ofNullable(winnerLotto);
    }
}
