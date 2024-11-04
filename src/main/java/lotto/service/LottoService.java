package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public List<Lotto> generateLottoNumbers(int purchaseAmount) {
        List<Lotto> generatedLotto = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> generatedLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(generatedLottoNumber);
            generatedLotto.add(new Lotto(generatedLottoNumber));
        }
        return generatedLotto;
    }
}
