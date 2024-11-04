package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

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
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }
}
