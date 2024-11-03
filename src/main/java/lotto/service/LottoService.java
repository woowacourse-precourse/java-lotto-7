package lotto.service;

import java.awt.geom.FlatteningPathIterator;
import java.util.List;
import lotto.Lotto;
import lotto.Winning;

public interface LottoService {
    List<Lotto> buyLotto(Integer lottoCount);
    List<Winning> calWinning();
    Float revenue();
}
