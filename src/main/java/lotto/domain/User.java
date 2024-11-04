package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private List<PurchaseLotto> purchaseLottos = new ArrayList<>();

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
