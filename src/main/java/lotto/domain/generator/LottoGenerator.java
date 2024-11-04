package lotto.domain.generator;

import java.util.List;
import lotto.domain.model.Lotto;

public interface LottoGenerator {
    List<Lotto> generateLottos(int purchaseAmount);
}
