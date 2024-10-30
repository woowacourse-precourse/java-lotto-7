package lotto.model;

import static lotto.constants.LottoConfig.NUMBERS_SIZE;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;

public class LottoMachine {

    public static List<Lotto> purchaseLottos(Money money) {
        List<Lotto> lottos = new LinkedList<>();
        while (lottos.size() < money.getLottoTicketCount()) {
            generateLotto(lottos);
        }
        return lottos;
    }

    private static void generateLotto(List<Lotto> lottos) {
        Lotto lotto = new Lotto(generateNumbers());
        if (!lottos.contains(lotto)) {
            lottos.add(lotto);
        }
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_MINIMUM, NUMBER_RANGE_MAXIMUM, NUMBERS_SIZE);
    }
}