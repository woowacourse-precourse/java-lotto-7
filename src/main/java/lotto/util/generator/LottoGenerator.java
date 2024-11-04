package lotto.util.generator;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoGenerator {

    Lotto generate();

    List<Lotto> generateByCount(int count);
}
