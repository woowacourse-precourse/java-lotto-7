package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(int count) {
        this.lottoList = new ArrayList<>();
        generateLottos(count);
    }

    public static Lottos from(final int count) {
        return new Lottos(count);
    }

    public int getLottoListSize() {
        return lottoList.size();
    }

    private void generateLottos(final int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.from(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)
            );
            lottoList.add(lotto);
        }
    }

}