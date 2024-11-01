package lotto.utils;

import static lotto.constants.LottoConfig.NUMBERS_SIZE;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.Money;

public class LottoMachine {


    public static List<Lotto> purchaseLottos(Money money) {
        validate(money);
        List<Lotto> lottos = new LinkedList<>();
        while (money.isPurchasable(lottos)) {
            generateLotto(lottos);
        }
        return lottos;
    }

    private static void validate(Money money) {
        if (money.isOutOfRange()) {
            throw new IllegalArgumentException(ErrorMessage.IS_OUT_OF_RANGE_PRICE.getMessage());
        }
        if (money.isIndivisibleBy()) {
            throw new IllegalArgumentException(ErrorMessage.IS_INDIVISIBLE_PRICE.getMessage());
        }
    }

    private static void generateLotto(List<Lotto> lottos) {
        Lotto lotto = new Lotto(generateNumbers());
        if (isNotDuplicatedNumbers(lottos, lotto)) {
            lottos.add(lotto);
        }
    }

    private static boolean isNotDuplicatedNumbers(List<Lotto> lottos, Lotto lotto) {
        return !lottos.contains(lotto);
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_MINIMUM, NUMBER_RANGE_MAXIMUM, NUMBERS_SIZE);
    }
}