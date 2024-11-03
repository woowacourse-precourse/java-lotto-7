package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.application.service.WinLotto;

public class InMemoryWinLottoRepository implements WinLottoRepository {

    private static final InMemoryWinLottoRepository INSTANCE = new InMemoryWinLottoRepository();

    private final List<WinLotto> winLottoRepository = new ArrayList<>();

    private InMemoryWinLottoRepository() {

    }

    public static InMemoryWinLottoRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(WinLotto winLotto) {
        winLottoRepository.add(winLotto);
    }

    @Override
    public WinLotto getRecent() {
        return winLottoRepository.getLast();
    }

    @Override
    public void clear() {
        winLottoRepository.clear();
    }
}
