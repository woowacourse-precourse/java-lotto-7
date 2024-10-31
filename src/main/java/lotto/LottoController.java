package lotto;

import lotto.common.Validator;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;
    private final Validator validator;

    public LottoController(InputView inputView, Validator validator) {
        this.inputView = inputView;
        this.validator = validator;
    }

    public void getUserInput() {
        getPrice();
    }

    private void getPrice() {
        String price = inputView.getPrice();
        validator.validatePrice(price);
        inputView.printPrice(price);
    }


}
