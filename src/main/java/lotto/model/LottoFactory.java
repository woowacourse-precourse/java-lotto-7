package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.RandomNumberGenerator.generateRandomLottoNumbers;


public class LottoFactory {
    public static LottoBundle makeLottosByWalletMoney(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(makeALotto(generateRandomLottoNumbers()));
        }

        return new LottoBundle(lottos);
    }

    private static Lotto makeALotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
