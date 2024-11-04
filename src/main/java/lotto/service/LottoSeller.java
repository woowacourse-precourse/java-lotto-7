package lotto.service;

import lotto.model.UserLottos;
import lotto.util.RetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.constant.ErrorMessage.INVALID_PURCHASE_PRICE_UNIT;

public class LottoSeller {
    static final int MONEY_UNIT = 1000;

    public LottoSeller() {
    }

    public UserLottos sell() {
        int inputPrice = RetryHandler.retryUntilSuccess(()->InputView.getPurchasePrice());
        UserLottos userLottos = RetryHandler.retryUntilSuccess(()->generateUserLottos(inputPrice));
        OutputView.printLottos(userLottos);
        return userLottos;
    }

    private UserLottos generateUserLottos(int inputPrice) {
        int sellLottoCount = convertToCount(inputPrice);
        UserLottos userLottos = new UserLottos(sellLottoCount, inputPrice);
        return userLottos;
    }

    public int convertToCount(int inputPrice) {
        if (inputPrice % MONEY_UNIT != 0)
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE_UNIT);
        return inputPrice / MONEY_UNIT;
    }
}
