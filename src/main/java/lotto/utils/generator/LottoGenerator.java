package lotto.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.Constants;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoGenerator {

    public static Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = Constants.ZERO.getValue(); i < count; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return new Lottos(lottos);
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER.getValue(),
                Constants.LOTTO_MAX_NUMBER.getValue(), Constants.LOTTO_LENGTH.getValue());
    }
}
