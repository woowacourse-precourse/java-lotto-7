package lotto.controller;

import java.util.List;
import lotto.model.LottoPurchaseHistory;
import lotto.model.lottoInfo.LottoGame;
import lotto.model.lottoInfo.PriceDataImpl;
import lotto.model.lottoInfo.StandardLottoPrice;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.ParseNumberUtil;
import lotto.validator.MoneyValidator;
import lotto.validator.NumberValidator;

public class LottoController {
    private static final LottoService lottoService = new LottoService();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final MoneyValidator moneyValidator = new MoneyValidator();
    private static final NumberValidator numberValidator = new NumberValidator();

    public void run() {
        LottoGame lottoGame = new LottoGame(new StandardLottoPrice(), new PriceDataImpl());
        int money = inputMoney(lottoGame.getPrice());

        LottoPurchaseHistory lottoPurchaseHistory = buyLotto(money, lottoGame.getPrice());
        printPurchaseHistory(lottoPurchaseHistory);

        lottoGame.enterWinningNumber(inputWinningNumber());
    }

    private List<Integer> inputWinningNumber() {
        while (true) {
            try {
                String winningInput = inputView.inputWinningNumber();
                List<Integer> winningNumbers = ParseNumberUtil.parseNumber(winningInput);
                numberValidator.checkNumberSize(winningNumbers);
                numberValidator.checkNumberDuplicated(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int inputMoney(int lottoPrice) {
        while(true) {
            try{
                String money = inputView.inputMoney();
                moneyValidator.validateNumeric(money);
                moneyValidator.validateDivideWithLottoPrice(Integer.parseInt(money), lottoPrice);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoPurchaseHistory buyLotto(int money, int lottoPrice) {
        int lottoAmount = money / lottoPrice;
        return lottoService.buyLotto(lottoAmount);
    }

    private void printPurchaseHistory(LottoPurchaseHistory lottoPurchaseHistory) {
        outputView.printPurchaseHistory(lottoPurchaseHistory.getPurchaseHistory());
    }
}
