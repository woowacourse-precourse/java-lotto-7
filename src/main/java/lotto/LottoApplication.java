package lotto;

public class LottoApplication {

    private final ApplicationView applicationView;

    public LottoApplication(ApplicationView applicationView) {
        this.applicationView = applicationView;
    }

    public void execute() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        int money = applicationView.requestMoney();
    }
}
