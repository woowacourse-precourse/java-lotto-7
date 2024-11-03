package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public interface LottoService {

    void buyLotto(String money);

    Map<Rank, Integer> calculateLottoResults(String winNumbers, String bonusNumber);

    List<Lotto> getAllLottos();

    void deleteLottos();

    String getPercent(Map<Rank, Integer> rankCounts);

    List<Integer> convertToNumbers(String winnerNumbers);
}
