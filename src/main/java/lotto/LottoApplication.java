package lotto;

public class LottoApplication {

    private final ApplicationView applicationView;
    private final MessageConverter<Lotto> messageConverter;
    private final PurchaseLottoUseCase purchaseLottoUseCase;

    public LottoApplication(ApplicationView applicationView, PurchaseLottoUseCase purchaseLottoUseCase) {
        this.applicationView = applicationView;
        this.messageConverter = messageConverter;
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
