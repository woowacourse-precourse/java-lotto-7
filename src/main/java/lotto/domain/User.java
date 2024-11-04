package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constant.LOTTO_PRICE;

public class User {
    private final int purchaseAmount;
    private final List<PurchaseLotto> purchaseLottos = new ArrayList<>();

    public User(int lottoTickets){
        this.purchaseAmount = lottoTickets * LOTTO_PRICE;
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }

    public List<PurchaseLotto> getPurchaseLottos(){
        return purchaseLottos;
    }

    public void AddPurchaseLottos(PurchaseLotto purchaseLotto){
        purchaseLottos.add(purchaseLotto);
    }
}
