package lotto;

import java.util.List;
import lotto.application.LottoResultUseCase;
import lotto.application.PurchaseLottoUseCase;
import lotto.application.RetrieveLottoUseCase;
import lotto.domain.Lotto;
import lotto.view.ApplicationView;
import lotto.view.converter.MessageParser;

public class LottoApplication {

    private final ApplicationView applicationView;
    private final MessageParser<Lotto> messageParser;
    private final PurchaseLottoUseCase purchaseLottoUseCase;
    private final RetrieveLottoUseCase retrieveLottoUseCase;
    private final LottoResultUseCase lottoResultUseCase;

    public LottoApplication(
            ApplicationView applicationView,
            MessageParser<Lotto> messageParser,
            PurchaseLottoUseCase purchaseLottoUseCase,
            RetrieveLottoUseCase retrieveLottoUseCase,
            LottoResultUseCase lottoResultUseCase
    ) {
        this.applicationView = applicationView;
        this.messageParser = messageParser;
        this.purchaseLottoUseCase = purchaseLottoUseCase;
        this.retrieveLottoUseCase = retrieveLottoUseCase;
        this.lottoResultUseCase = lottoResultUseCase;
    }

    public void execute() {
        purchaseLotto();

        showPurchasedLotto();

        drawWinner();

    }

    private void purchaseLotto() {
        int money = applicationView.requestMoney();
        purchaseLottoUseCase.purchase(money);
    }

    private void showPurchasedLotto() {
        List<Lotto> purchasedLotto = retrieveLottoUseCase.retrieveAll();
        applicationView.printPurchasedLotto(messageParser.toMessages(purchasedLotto));
    }

    private void drawWinner() {
        String winNumber = applicationView.requestWinNumber();
        int bonusNumber = applicationView.requestBonusNumber();
        lottoResultUseCase.createWinLotto(messageParser.toNumbers(winNumber), bonusNumber);
        lottoResultUseCase.checkWinning();
    }
}
