package lotto.service;

import java.awt.geom.FlatteningPathIterator;
import java.util.List;
import lotto.Lotto;

public interface LottoService {
    List<Lotto> buyLotto(Integer lottoCount);
    void calWinning();
    Float revenue();
}
