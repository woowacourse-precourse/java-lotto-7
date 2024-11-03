package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {
    public List<Lotto> CreateLottos(int money) {
        List<Lotto> Lottos = new ArrayList<>();
        for (int i=0; i<money/1000; i++) {
            List<Integer> numbers = LottoNumbers();
            Lottos.add(new Lotto(numbers));
        }
        return Lottos;
    }

    private List<Integer> LottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
}
