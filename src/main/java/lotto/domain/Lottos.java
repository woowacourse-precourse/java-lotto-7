package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos (List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos () {
        return lottos;
    }

    public Integer size() {
        return lottos.size();
    }

    public List<String> lottosToString () {
        List<String> lottosToString = new ArrayList<>();

        for (Lotto lotto: lottos) {
            String lottoToString = lotto.toString();

            lottosToString.add(lottoToString);
        }

        return lottosToString;
    }
}
