package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.Constants.*;
import static lotto.message.ErrorMessage.*;
public class User {
    int buyAmount;

    private List<Lotto> lottos = new ArrayList<>();

    public User(int buyAmount) {
        validateBuyAmount(buyAmount);
        this.buyAmount = buyAmount;
    }

    public int getBuyLottoCount(){
        return buyAmount/BUY_AMOUNT_UNIT;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void buyLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private void validateBuyAmount(int buyAmount){
        validateBuyAmountRange(buyAmount);
        validateBuyAmountThousandUnit(buyAmount);
    }

    private void validateBuyAmountThousandUnit(int buyAmount) {
        if(isNotDivisibleByThousand(buyAmount)){
            throw new IllegalArgumentException(BUY_AMOUNT_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    private boolean isNotDivisibleByThousand(int buyAmount) {
        return buyAmount % BUY_AMOUNT_UNIT != 0;
    }

    private void validateBuyAmountRange(int buyAmount){
        if(isLessThanThousand(buyAmount)){
            throw new IllegalArgumentException(BUY_AMOUNT_LESS_THAN_THOUSAND.getMessage());
        }
    }

    private boolean isLessThanThousand(int buyAmount){
        return buyAmount < BUY_AMOUNT_UNIT;
    }

}
