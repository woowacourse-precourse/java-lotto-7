package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.WinnerLotto;
import lotto.repository.SingleRepository;

public class WinnerLottoRepository implements SingleRepository<WinnerLotto> {

    private WinnerLotto winnerLotto;

    @Override
    public void save(WinnerLotto object) {
        this.winnerLotto = object;
    }

    @Override
    public Optional<WinnerLotto> get() {
        return Optional.ofNullable(winnerLotto);
    }
}
