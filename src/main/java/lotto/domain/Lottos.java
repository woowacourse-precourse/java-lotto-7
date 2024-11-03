package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<List<Lotto>> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void makeLottos(User user) {
        int lottoAmount = user.getNumOfLottos();

        for (int lotto = 0; lotto < lottoAmount; lotto++) {
            lottos.add(new ArrayList<>());
        }
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
