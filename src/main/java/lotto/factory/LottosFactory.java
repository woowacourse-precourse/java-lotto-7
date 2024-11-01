package lotto.factory;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottosFactory {
    public static Lottos createLottos(List<List<Integer>> allNumbers) {
        List<Lotto> lottos = allNumbers.stream()
                .map(LottoFactory::creatLotto)
                .toList();

        return new Lottos(lottos);
    }
}
