package lotto.service;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoService {

    void buyLotto(String money);

    void checkLotto(String winNumbers, String bonusNumber);

    List<Lotto> getAllLottos();

    void deleteLottos();

}
