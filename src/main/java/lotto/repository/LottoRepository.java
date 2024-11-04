package lotto.reposi;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public interface LottoRepository {

    void saveLottoNumbers(List<List<Integer>> lottoNumbers);

    List<List<Integer>> getLottoNumbers();

    void saveWinningNumbers(Lotto winningLotto);

    void saveBonusNumbers(Bonus Bonus);

    Lotto getWinningNumbers();

    Bonus getBonusNumber();
}
