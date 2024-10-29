package lotto.model;

import java.util.ArrayList;

public class Lotto {

    private ArrayList<Integer> lotto;

    public Lotto(ArrayList<Integer> lotto) {
        this.lotto = lotto;
    }

    public ArrayList<Integer> getLotto() {
        return lotto;
    }
}
