package lotto.service;

import java.awt.geom.FlatteningPathIterator;
import java.util.List;
import lotto.Lotto;

public interface LottoService {
    List<Lotto> buyLotto(int money);
    void calWinning();
    Float revenue();
}
