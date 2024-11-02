package lotto.domain.lottoGeneratir;

import java.util.List;
import lotto.dto.Lotto;
import lotto.dto.WinningLotto;

public class RandomLottoGenerator implements LottoGenerator{
    @Override
    public Lotto generateLotto(List<Integer> randomNumbers) {
        return new Lotto(randomNumbers);
    }

    @Override
    public WinningLotto generateWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }
}
