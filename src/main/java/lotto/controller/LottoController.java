package lotto.controller;

import lotto.Consumer;
import lotto.constant.CompareInteger;
import lotto.constant.PriceRule;
import lotto.validator.NumberValidator;
import lotto.validator.PriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.constant.CompareInteger.PRICE_MAXIMUM;
import static lotto.constant.CompareInteger.PRICE_MINIMUM;
import static lotto.constant.PriceRule.SCOPE;

public class LottoController {
    public void run() {
        OutputView.printPriceGuide();
        Consumer consumer = new Consumer(getLottoPrice());
        OutputView.printPurchaseCount(consumer.getLottoTicket().size());
    }

    private int getLottoPrice() {
        try {
            String inputPrice = InputView.readInput();
            int price = inputToInt(inputPrice);
            validatePrice(price);
            return price / CompareInteger.PRICE_LOTTO.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoPrice();
        }
    }

    private int inputToInt(String input) throws IllegalArgumentException {
        NumberValidator.validateOnlyInteger(input, PriceRule.ONLY_INTEGER.getMessage());
        return Integer.parseInt(input);
    }

    private void validatePrice(int price) {
        NumberValidator.validateScope(PRICE_MINIMUM.getNumber(), PRICE_MAXIMUM.getNumber(), price, SCOPE.getMessage());
        PriceValidator.validatePriceUnit(price);
    }
}
