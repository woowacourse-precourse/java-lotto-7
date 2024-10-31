package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    private final int lottoCount;
    List<Lotto> lottos;

    public LottoMaker(int lottoCount) {
        this.lottoCount = lottoCount;
        lottos = new ArrayList<>(lottoCount);
    }

    public void makeLottos() {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(getRandomNumbers());
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
