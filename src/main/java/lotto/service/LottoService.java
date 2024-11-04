package lotto.service;

import lotto.domain.Price;
import lotto.exceptionHandler.ExceptionHandler;
import lotto.view.InputView;

public class LottoService {

    private Price price;

    public void inputPrice() {
        ExceptionHandler.handle(() -> {
            int value = InputView.inputPrice();
            price = Price.from(value);
        });
    }
}