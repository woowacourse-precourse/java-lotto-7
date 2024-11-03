package lotto.domain;

import lotto.message.ErrorMessage;
import lotto.validation.AmountValidator;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoTickets;

    public PurchaseAmount(String strAmount){
        this.lottoTickets = validateAmount(parseToInt(strAmount)) / LOTTO_PRICE;
    }

    public int getLottoTickets(){
        return lottoTickets;
    }

    private int parseToInt(String strAmount){
        try {
            return Integer.parseInt(strAmount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private int validateAmount(int amount){
        AmountValidator.isPositive(amount);
        AmountValidator.isDivisibleByThousand(amount);
        return amount;
    }
}
