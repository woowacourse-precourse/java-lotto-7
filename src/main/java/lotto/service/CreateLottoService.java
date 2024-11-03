package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoService {
    public static Lotto createRandomLotto(int lottoNum) {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, lottoNum);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }
}
