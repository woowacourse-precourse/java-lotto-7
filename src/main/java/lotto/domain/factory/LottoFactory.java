package lotto.domain.factory;

import static lotto.config.GameConstant.PRICE_OF_LOTTO;
import static lotto.util.RandomNumberGenerator.generateRandomNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class LottoFactory {
    private LottoFactory() {
    }
    public static List<Lotto> generateLotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        long numberOfLotto = money.getMoney() / PRICE_OF_LOTTO;

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }
}
