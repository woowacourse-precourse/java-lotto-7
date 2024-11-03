package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int count;
    private final List<Lotto> lottos;

    public int getCount() {
        return count;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoGenerator(int count) {
        this.count = count;
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
    }

    private List<Integer> generateNumbers() {
        List<Integer> mutableLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(mutableLotto);
        return mutableLotto;
    }
}
