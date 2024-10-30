package model;

import java.util.ArrayList;
import lotto.Lotto;

public class LottoCollection {

    private ArrayList<Lotto> lottos;

    public LottoCollection() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
