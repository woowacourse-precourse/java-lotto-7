package lotto;

public interface PurchaseLottoUseCase {

    void purchase(int count);

    int calculatePurchaseCount(int money);
}
