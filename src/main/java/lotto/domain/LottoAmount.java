package lotto.domain;

import lotto.view.ExceptionMessage;

public class LottoAmount {

    private static final int LOTTO_MIN_PRICE = 1000;
    private final int amount;

    public LottoAmount(String purchasePrice){
        int price = validatePurchasePrice(purchasePrice);
        validatePositivePrice(price);
        validatePriceUnit(price);
        this.amount = price / LOTTO_MIN_PRICE;
    }

    private int validatePurchasePrice(String purchasePrice) throws IllegalArgumentException{
        try{
            return Integer.parseInt(purchasePrice);
        }catch (NumberFormatException e){
            ExceptionMessage.priceNumberException();
            throw new IllegalArgumentException();
        }
    }

    private void validatePriceUnit(int price) throws IllegalArgumentException{
        if(price % LOTTO_MIN_PRICE != 0){
            ExceptionMessage.priceUnitException();
            throw new IllegalArgumentException();
        }
    }

    private void validatePositivePrice(int price) throws IllegalArgumentException{
        if(price <= 0){
            ExceptionMessage.priceMustBePositiveException();
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
