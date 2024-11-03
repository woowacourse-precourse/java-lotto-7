package lotto.repository.mock;

import java.util.Optional;
import lotto.domain.WinnerLotto;
import lotto.repository.SingleRepository;

public class MockWinnerLottoRepository implements SingleRepository<WinnerLotto> {

    private final WinnerLotto winnerLotto;

    public MockWinnerLottoRepository(WinnerLotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    @Override
    public WinnerLotto save(WinnerLotto object) {
        return object;
    }

    @Override
    public Optional<WinnerLotto> get() {
        return Optional.ofNullable(winnerLotto);
    }
}
