package lotto;

import java.util.List;
import lotto.application.FacadeLottoUseCase;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinResult;
import lotto.view.ApplicationView;
import lotto.view.converter.MessageParser;
import lotto.view.dto.WinningInfo;

public class LottoApplication {

    private final ApplicationView applicationView;
    private final MessageParser<Lotto> messageParser;
    private final FacadeLottoUseCase facadeLottoUseCase;


    public LottoApplication(
            ApplicationView applicationView,
            MessageParser<Lotto> messageParser,
            FacadeLottoUseCase facadeLottoUseCase
    ) {
        this.applicationView = applicationView;
        this.messageParser = messageParser;
        this.facadeLottoUseCase = facadeLottoUseCase;
    }

    public void execute() {
        purchaseLotto();

        showPurchasedLotto();

        drawWinner();

        showResult();
    }

    private void purchaseLotto() {
        int money = applicationView.requestMoney();
        facadeLottoUseCase.purchase(Money.from(money));
    }

    private void showPurchasedLotto() {
        List<Lotto> purchasedLotto = facadeLottoUseCase.retrieveAll();
        applicationView.printPurchasedLotto(messageParser.toMessages(purchasedLotto));
    }

    private void drawWinner() {
        String winNumber = applicationView.requestWinNumber();
        int bonusNumber = applicationView.requestBonusNumber();
        facadeLottoUseCase.createWinLotto(messageParser.toNumbers(winNumber), bonusNumber);
        facadeLottoUseCase.checkWinning();
    }

    private void showResult() {
        WinResult winResult = facadeLottoUseCase.getWinResult();
        applicationView.printWinningResult(WinningInfo.from(winResult));
        float profitRate = facadeLottoUseCase.calculateProfitRate();
        applicationView.printProfitRate(profitRate);
    }
}
