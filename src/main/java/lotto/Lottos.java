package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateLottosByCount(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateLottoTicket());
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
