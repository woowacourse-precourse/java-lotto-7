package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int amount;
    private double rateOfReturn;
    private List<Lotto> lottos;

    public User(int amount) {
        this.amount = amount;
        this.rateOfReturn = 0.0;
        this.lottos = new ArrayList<>();
    }

    public int getPurchaseCount() {
        return this.amount / 1_000;
    }

    public void updateLottos(List<Lotto> lottos){
        this.lottos =  lottos;
    }
}
