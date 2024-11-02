package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoService {
    public Lotto generateLotto() {
        List<Integer> numbers = generateRandomNumbers();

        Lotto lotto = new Lotto(numbers);
        lotto.sortNumbers();

        return lotto;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }
}
