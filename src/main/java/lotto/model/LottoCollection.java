package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoCollection(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = getRandomLotto();
            lottoList.add(lotto);
        }
    }

    private Lotto getRandomLotto() {
        List<Integer> randomNumbers = RandomNumbers.getRandomNumbers();
        return new Lotto(randomNumbers);
    }
}
