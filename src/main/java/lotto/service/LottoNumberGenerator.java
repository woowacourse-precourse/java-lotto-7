package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import static lotto.constatnt.LottoConstants.*;

public class LottoNumberGenerator {

    public Lottos generateLottoNumbers(int lottoCount) {
        List<Lotto> allLottoNumbers = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE);
            allLottoNumbers.add(new Lotto(lottoNumbers));
        }

        return new Lottos(allLottoNumbers);
    }
}