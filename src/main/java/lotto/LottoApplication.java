package lotto;

public class LottoApplication {

    private final ApplicationView applicationView;
    private final PurchaseLottoUseCase purchaseLottoUseCase;

    public LottoApplication(ApplicationView applicationView, PurchaseLottoUseCase purchaseLottoUseCase) {
        this.applicationView = applicationView;
        this.purchaseLottoUseCase = purchaseLottoUseCase;
    }

    public void execute() {
        purchaseLotto();

        showPurchaseLotto();


    }

    private void purchaseLotto() {
        int money = applicationView.requestMoney();
        purchaseLottoUseCase.purchase(money);
    }

    private void showPurchaseLotto() {
    }
}
