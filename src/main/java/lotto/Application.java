package lotto;

import java.math.BigInteger;
import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.domain.LottoBuyer;
import lotto.domain.WinningLotto;
import lotto.view.InputValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.createLottoController();
        InputView inputView = appConfig.createInputView();
        InputValidator inputValidator = appConfig.createInputValidator();

        BigInteger purchaseAmount = new BigInteger(inputView.requestPurchaseAmount());
        LottoBuyer lottoBuyer = lottoController.buyLottosWith(purchaseAmount);

        String input = inputView.requestWinningLottoNumbers();
        WinningLotto winningLotto = lottoController.extractLottoNumbers(input, inputValidator);
    }
}
