package lotto.domain.lottoGeneratir;

import java.util.List;
import lotto.dto.Lotto;
import lotto.dto.WinningLotto;

public interface LottoGenerator {
    Lotto generateLotto(List<Integer> randomNumbers);
    WinningLotto generateWinningLotto(List<Integer> numbers, int bonusNumber);
}
