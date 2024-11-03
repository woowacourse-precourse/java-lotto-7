package model;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {

    private ArrayList<Lotto> lottos;

    public LottoCollection() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
