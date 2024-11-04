package lotto.controller;

import static lotto.utils.Constants.*;

import lotto.model.Cashier;
import lotto.model.LottoManager;
import lotto.utils.ErrorMessage;
import lotto.view.*;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;
    private final Cashier cashier;

    public LottoController(InputView inputView, OutputView outputView, LottoManager lottoManager, Cashier cashier) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = lottoManager;
        this.cashier = cashier;
    }

    public void run() {
        buyLotto();
    }

    public void buyLotto() {
        try {
            int price = validateIsNumberAndParse(inputView.input(INPUT_PRICE_MESSAGE));
            cashier.payPrice(price);
            int count = cashier.getLottoCount();
            outputView.printBuyResult(count);
            buy(count);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            buyLotto();
        }
    }

    private void buy(int count) {
        for (int i = 0; i < count; i++) {
            outputView.printLottoTicket(lottoManager.addLotto());
        }
    }

    private int validateIsNumberAndParse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_NUMBER.getMessage());
        }
    }
}
