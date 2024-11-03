package lotto;

import java.util.List;

public class LottoApplication {

    private final ApplicationView applicationView;
    private final MessageConverter<Lotto> messageConverter;
    private final PurchaseLottoUseCase purchaseLottoUseCase;
    private final RetrieveLottoUseCase retrieveLottoUseCase;

    public LottoApplication(ApplicationView applicationView, MessageConverter<Lotto> messageConverter, PurchaseLottoUseCase purchaseLottoUseCase,
            RetrieveLottoUseCase retrieveLottoUseCase) {
        this.applicationView = applicationView;
        this.messageConverter = messageConverter;
        this.purchaseLottoUseCase = purchaseLottoUseCase;
        this.retrieveLottoUseCase = retrieveLottoUseCase;
    }

    public void execute() {
        purchaseLotto();

        showPurchasedLotto();


    }

    private void purchaseLotto() {
        int money = applicationView.requestMoney();
        purchaseLottoUseCase.purchase(money);
    }

    private void showPurchasedLotto() {
        List<Lotto> purchasedLotto = retrieveLottoUseCase.retrieveAll();
        applicationView.printPurchasedLotto(messageConverter.convert(purchasedLotto));
    }
}
