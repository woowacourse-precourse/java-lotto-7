package lotto.utils;

import static lotto.constants.LottoConfig.NUMBERS_SIZE;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Money;

public class LottoMachine {

    public static List<Lotto> purchaseLottos(Money money) {
        List<Lotto> lottos = new LinkedList<>();
        while (money.isPurchasable(lottos)) {
            generateLotto(lottos);
        }
        return lottos;
    }

    private static void generateLotto(List<Lotto> lottos) {
        Lotto lotto = new Lotto(generateLottoNumbers());
        if (!isDuplicateNumbers(lottos, lotto)) {
            lottos.add(lotto);
        }
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_MINIMUM, NUMBER_RANGE_MAXIMUM, NUMBERS_SIZE);
    }

    private static boolean isDuplicateNumbers(List<Lotto> lottos, Lotto lotto) {
        return lottos.contains(lotto);
    }
}