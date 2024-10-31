package lotto.service;

import lotto.domain.User;
import lotto.validate.PriceValidate;

import static lotto.view.InputView.*;

public class InputService {

    private int priceValidate() {
        PriceValidate validate = new PriceValidate(inputLottoMoney());
        return validate.getPrice();
    }

    public User getUser() {
        return new User(priceValidate());
    }
}
