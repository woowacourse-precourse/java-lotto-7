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
        Lotto winning = winningRepository.getWinning();
        List<Integer> numbers = winning.getLotto();

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 번호가 있습니다.");
        }
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 - 45범위의 경계를 포함한 값이여야합니다.");
        }
        winningRepository.saveBonusNumber(bonusNumber);
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 45;
    }
}
