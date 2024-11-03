package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(int quantityOfLottos) {
        return new Lottos(LottoFactory.createLottos(quantityOfLottos));
    }

    public String allLottosToString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
          sb.append(lotto.sortedNumbersToString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
