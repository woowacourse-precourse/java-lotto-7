package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();

    public void buyLotto(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구매 금액이 로또 금액으로 나누어 떨어지지 않습니다.");
        }

        int numberOfLotto = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(LottoGenerator.generate()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
