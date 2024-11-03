package lotto.application.service;

import java.util.List;
import lotto.LottoResultUseCase;
import lotto.domain.Lotto;
import lotto.domain.repository.WinLottoRepository;

public class LottoResultService implements LottoResultUseCase {

    private final WinLottoRepository winLottoRepository;

    public LottoResultService(WinLottoRepository winLottoRepository) {
        this.winLottoRepository = winLottoRepository;
    }

    @Override
    public void createWinLotto(List<Integer> numbers, int bonusNumber) {
        WinLotto winLotto = WinLotto.of(Lotto.create(numbers), bonusNumber);
        winLottoRepository.save(winLotto);
    }
}
