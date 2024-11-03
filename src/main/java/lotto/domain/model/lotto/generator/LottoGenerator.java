package lotto.domain.model.lotto.generator;

import lotto.domain.model.user.Lotto;

import java.util.List;

public interface LottoGenerator {

    List<Lotto> generateByQuantity(int quantity);

    Lotto generateLotto();
}
