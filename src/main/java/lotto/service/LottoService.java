package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoService {

    public List<Lotto> buyLotto(int amount) {
        List<Integer> number;
        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < amount / 1000; i++) {
            number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            number = sortLotto(number);
            Lotto lotto = new Lotto(number);
            lottos.add(lotto);
        }
        return lottos;
    }


    public List<Integer> sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers;
    }
}
