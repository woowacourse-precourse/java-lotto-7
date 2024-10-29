package lotto.model;

import lotto.dto.CreateLottoInfo;

public class UserLottoInfo {
    private final Lottos lottos;
    private final Money purchaseAmount;

    public UserLottoInfo(long purchaseAmount) {
        this.purchaseAmount = new Money(purchaseAmount);
        this.lottos = new Lottos(this.purchaseAmount.getThousandUnitCount());
    }

    public CreateLottoInfo getUserLottos() {
        return lottos.getUserLottos();
    }
}
