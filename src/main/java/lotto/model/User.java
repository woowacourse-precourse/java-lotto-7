package lotto.model;

import lotto.validation.UserValidation;

import java.util.ArrayList;
import java.util.List;

public class User {
    int buyAmount;
    List<Lotto> lottos = new ArrayList<>();

    public User(int buyAmount) {
        UserValidation.validateBuyAmount(buyAmount);
        this.buyAmount = buyAmount;
    }

    public int getBuyLottoCount(){
        return buyAmount/1000;
    }

    public void buyLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

}
