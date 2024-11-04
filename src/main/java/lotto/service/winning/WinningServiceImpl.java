package lotto.service.winning;

import java.util.List;
import lotto.Lotto;
import lotto.repository.winning.WinningRepository;

public class WinningServiceImpl implements WinningService {
    private final WinningRepository winningRepository;

    public WinningServiceImpl(WinningRepository winningRepository) {
        this.winningRepository = winningRepository;
    }

    @Override
    public void saveWinning(List<Integer> numbers) {
        Lotto winning = new Lotto(numbers);
        winningRepository.saveWinning(winning);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {

    }
}
