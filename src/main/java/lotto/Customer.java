package lotto;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Lotto> lottos;
    private int jackpot;
    private Lotto correctNumber;

    Customer(){
        lottos = new ArrayList<>();
        jackpot = 0;
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }
}
