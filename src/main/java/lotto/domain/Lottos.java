package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos autoGenerate(long count) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            generatedLottos.add(Lotto.auto());
        }
        return new Lottos(generatedLottos);
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
