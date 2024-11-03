package lotto.model;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.DelimiterPattern.*;
import static lotto.constant.Constants.*;

public class PurchaseQuantity {

    private final Integer purchaseQuantity; //판매 수량

    public PurchaseQuantity(String price){
        validate(price);
        this.purchaseQuantity = Integer.parseInt(price)/ DIVISOR.getConstant();
    }

    private void validate(String price){
        if(price.isEmpty()) throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        if(!price.matches(NUMBER_VALIDATION_REGEX.getPattern())) throw new IllegalArgumentException(NOT_NATURAL_NUMBER.getMessage());
        if(Integer.parseInt(price)<=Zero.getConstant()) throw new IllegalArgumentException(NOT_NATURAL_NUMBER.getMessage());
        if(Integer.parseInt(price)%DIVISOR.getConstant()!=Zero.getConstant()) throw new IllegalArgumentException(NOT_THOUSAND_PRICE.getMessage());
    }

    public Integer getPurchaseQuantity(){return this.purchaseQuantity;}
}
