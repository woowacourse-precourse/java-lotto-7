package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public Lottos() {
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

}