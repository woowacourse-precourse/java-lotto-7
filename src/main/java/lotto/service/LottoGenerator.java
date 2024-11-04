package lotto.service;

import lotto.domain.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lotto = new ArrayList<>(lottoCount);
        while(lottoCount > 0) {
            lotto.add(validateLotto());
            lottoCount--;
        }
        return lotto;
    }
    private Lotto validateLotto() {
        List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumber);
        return new Lotto(lottoNumber);
    }
}
