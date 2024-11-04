package lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(List<List<Integer>> lottoList) {
        for (List<Integer> lotto : lottoList) {
            lottos.add(new Lotto(lotto));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
