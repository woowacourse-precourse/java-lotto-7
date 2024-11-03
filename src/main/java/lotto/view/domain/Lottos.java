package lotto.view.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final static int LOTTO_AMOUNT = 1000;
    private final List<Lotto> lottos;

    public Lottos(Amount amount) {
        lottos = new ArrayList<>();
        int lottoCount = calculateLottoCount(amount.getValue());

        for (int i = 1; i <= lottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    private int calculateLottoCount(Integer amount) {
        return amount / LOTTO_AMOUNT;
    }

    @Override
    public String toString() {
        return lottos.size() + "개를 구매했습니다.\n"
                + lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
