package lotto.entity;

import lotto.validator.Validator;
import lotto.validator.input.PriceValidator;

public class Price {
    private final int price;
    private Validator validator;
    public Price(String inputValue){
        initializeValidator(inputValue);
        validate();

        this.price = parsePrice(inputValue);
    }

    private void validate(){
        validator.validate();
    }

    private void initializeValidator(String inputValue){
        this.validator = new PriceValidator(inputValue);
    }

    private int parsePrice(String inputValue){
        return Integer.parseInt(inputValue);
    }
}
