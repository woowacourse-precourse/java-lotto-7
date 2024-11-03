package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoNumberGenerator {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public Lottos generateLottoNumbers(int lottoCount) {
        List<Lotto> allLottoNumbers = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBERS_COUNT);
            allLottoNumbers.add(new Lotto(lottoNumbers));
        }

        return new Lottos(allLottoNumbers);
    }
}
