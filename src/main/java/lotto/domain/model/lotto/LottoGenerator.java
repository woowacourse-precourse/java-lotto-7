package lotto.domain.model.lotto;

import java.util.List;

public interface LottoGenerator {

    List<Lotto> generateByQuantity(int quantity);

    Lotto generateLotto();
}
