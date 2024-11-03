package lotto;

public class PurchaseLottoService implements PurchaseLottoUseCase {

    private static final int UNIT_OF_MONEY = 1000;

    @Override
    public void purchase(int money) {
        int purchaseCount = money / UNIT_OF_MONEY;
        List<Lotto> purchasedLottos = lottoFactory.createByCount(purchaseCount);
    }
}
