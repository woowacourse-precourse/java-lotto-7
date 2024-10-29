package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.port.RandomHolder;

public class LottoService {
    private List<Lotto> lottos = new ArrayList<>();
    private final RandomHolder randomHolder;

    public LottoService(RandomHolder randomHolder) {
        this.randomHolder = randomHolder;
    }

    public List<Lotto> purchaseLottos(int amount) {
        int quantity = amount / 1000;
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(randomHolder.getNumbers()));
        }
        return lottos;
    }
}
