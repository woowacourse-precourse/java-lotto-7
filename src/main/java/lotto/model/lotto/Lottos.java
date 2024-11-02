package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public static Lottos generate(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoGenerator.generate()));
        }

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
