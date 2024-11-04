package lotto.model;

import java.util.List;

public interface LottoService {
    void buyLotto(int amount);

    List<Lotto> getLottoList();
}
