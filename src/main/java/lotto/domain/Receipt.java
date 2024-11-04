package lotto.domain;

public class Receipt {
    private final Lottos lottos;
    private final int purchaseAmount;

    public Receipt(Lottos lottos, int purchaseAmount) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmount;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
