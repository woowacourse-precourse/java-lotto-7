package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public List<Lotto> generateLotto(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lotto.add(new Lotto(randomNumbers));
        }

        return lotto;
    }
}
