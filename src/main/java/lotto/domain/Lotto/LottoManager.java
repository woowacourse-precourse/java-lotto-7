package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;

    public LottoManager() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void createLottosByRandomNumbers(List<Integer> randomNumbers) {
        Lotto lotto = new Lotto(randomNumbers);
        lottos.add(lotto);
    }
}
