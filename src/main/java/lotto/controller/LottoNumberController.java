package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberController {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> issueLottos(int amount) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            issuedLottos.add(new Lotto(getRandomLottoNumbers()));
        }
        return issuedLottos;
    }

    private List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_NUMBER_COUNT);
    }
}
