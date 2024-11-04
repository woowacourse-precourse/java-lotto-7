package lotto.service.winning;

import java.util.List;
import lotto.Lotto;
import lotto.exception.winning.LottoNumberDuplicatedException;
import lotto.exception.winning.LottoNumberOutOfRangeException;
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
        Lotto winning = winningRepository.getWinning();
        List<Integer> numbers = winning.getLotto();

        if (numbers.contains(bonusNumber)) {
            throw new LottoNumberDuplicatedException();
        }
        if (isOutOfRange(bonusNumber)) {
            throw new LottoNumberOutOfRangeException();
        }
        winningRepository.saveBonusNumber(bonusNumber);
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 45;
    }
}
