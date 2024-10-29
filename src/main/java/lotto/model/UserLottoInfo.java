package lotto.model;

public class UserLottoInfo {
    private Lottos lottos;
    private Money purchaseAmount;

    public UserLottoInfo(long purchaseAmount) {
        this.purchaseAmount = new Money(purchaseAmount);
        this.lottos = new Lottos(this.purchaseAmount.getThousandUnitCount());
    }
}
