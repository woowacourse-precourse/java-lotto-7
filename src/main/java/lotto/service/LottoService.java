package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public List<Lotto> createLotto(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = createLottoNumber();
            numbers = sortLottoNumber(numbers);

            Lotto newLotto = new Lotto(numbers);
            lottos.add(newLotto);
        }

        return lottos;
    }

    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> sortLottoNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
