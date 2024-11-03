package lotto.controller;

import lotto.model.lottoInfo.LottoInfo;
import lotto.model.lottoInfo.PriceDataImpl;
import lotto.model.lottoInfo.StandardLottoPrice;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.validator.MoneyValidator;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final MoneyValidator moneyValidator = new MoneyValidator();

    public void run() {
        LottoInfo lottoInfo = new LottoInfo(new StandardLottoPrice(), new PriceDataImpl());
        int money = inputMoney(lottoInfo.getPrice());
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
}
