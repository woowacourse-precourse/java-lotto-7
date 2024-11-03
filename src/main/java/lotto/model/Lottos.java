package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public static Lottos from(int amount) {
        List<Lotto> lottos = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lotto));
        }
        return new Lottos(lottos);
    }

    public static Lottos from(Budget budget) {
        int amount = budget.getBudget() / 1000;
        return from(amount);
    }
}
