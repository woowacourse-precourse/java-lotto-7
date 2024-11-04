package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private LottoGenerator() {
    }

    public static List<Lotto> getRandomLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.RANDOM_LOWER_BOUND,
                LottoConstants.RANDOM_UPPER_BOUND,
                LottoConstants.NUMBER_OF_LOTTO
        );

        return lottoNumbers.stream().sorted().toList();
    }
}
