package lotto.model;

import lotto.constant.Constants;
import lotto.constant.DelimiterPattern;
import lotto.constant.ErrorMessage;

public class PurchaseQuantity {

    private final Integer purchaseQuantity; //판매 수량

    public PurchaseQuantity(String price){
        validate(price);
        this.purchaseQuantity = Integer.parseInt(price)/ Constants.DIVISOR.getConstant();
    }

    private void validate(String price){
        if(price.isEmpty()) throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        if(!price.matches(DelimiterPattern.NUMBER_VALIDATION_REGEX.getPattern())) throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
        if(Integer.parseInt(price)<=Constants.Zero.getConstant()) throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
        if(Integer.parseInt(price)%Constants.DIVISOR.getConstant()!=Constants.Zero.getConstant()) throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_PRICE.getMessage());
    }
}
