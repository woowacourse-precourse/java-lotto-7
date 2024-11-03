package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<PurchaseLotto> purchaseLottos = new ArrayList<>();

    public List<PurchaseLotto> getPurchaseLottos(){
        return purchaseLottos;
    }

    public void AddPurchaseLottos(PurchaseLotto purchaseLotto){
        purchaseLottos.add(purchaseLotto);
    }
}
