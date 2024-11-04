package lotto.repository;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public interface LottoRepository {

    void saveUserLottoNumbers(List<List<Integer>> lottoNumbers);

    List<List<Integer>> getUserLottoNumbers();

    void saveWinningNumbers(Lotto winningLotto);

    void saveBonusNumbers(Bonus Bonus);

    Lotto getWinningNumbers();

    Bonus getBonusNumber();
}
