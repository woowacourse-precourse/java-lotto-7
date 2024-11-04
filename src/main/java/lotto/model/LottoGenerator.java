package lotto.model;

import static lotto.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_SIZE);
    }
}
