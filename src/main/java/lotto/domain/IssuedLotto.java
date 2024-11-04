package lotto.domain;

import java.util.List;

public interface IssuedLotto {
    List<Lotto> getIssuedLottos();

    int getLottoPurchaseAmount();

    void generateIssuedLottos();
}
