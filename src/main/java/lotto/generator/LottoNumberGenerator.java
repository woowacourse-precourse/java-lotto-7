package lotto.generator;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoNumberGenerator {
    List<Lotto> generate(int amount);
}
