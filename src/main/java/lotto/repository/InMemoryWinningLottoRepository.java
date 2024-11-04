package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningLotto;

public class InMemoryWinningLottoRepository implements WinningLottoRepository {

    private final List<WinningLotto> storedWinningLotto;

    public InMemoryWinningLottoRepository() {
        this.storedWinningLotto = new ArrayList<>();
    }

    @Override
    public void save(WinningLotto winningLotto) {
        storedWinningLotto.add(winningLotto);
    }

    @Override
    public WinningLotto findLast() {
        return storedWinningLotto.getLast();
    }


}
