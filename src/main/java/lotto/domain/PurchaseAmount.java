package lotto.domain;

import static lotto.message.ErrorMessage.*;
import static lotto.util.LottoConfig.LOTTO_PRICE;

public class PurchaseAmount {
    private final int amount;
    private final int quantity;
    public PurchaseAmount(String amount){
        try{
            this.amount = Integer.parseInt(amount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_NATURAL_AMOUNT.getMessage());
        }
        validateAmount(this.amount);
        quantity = this.amount/LOTTO_PRICE.getNumber();
    }
    private void validateAmount(int inputAmount){
        if(inputAmount % LOTTO_PRICE.getNumber() != 0 || inputAmount <= 0){
            throw new IllegalArgumentException(INVALID_NATURAL_AMOUNT.getMessage());
        }
    }
    public int getQuantity() {
        return quantity;
    }
}
