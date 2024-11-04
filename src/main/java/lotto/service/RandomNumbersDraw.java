package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersDraw {
    private final int MIN_NUMBER_RANGE = 1;
    private final int MAX_NUMBER_RANGE = 45;
    private final int RANDOM_NUMBER_COUNT = 6;

    public List<Lotto> randomLottoNumberDraw(int numberOfPurchases) {
        List<Lotto> lottoDrawNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPurchases; i++) {
            Lotto lotto = new Lotto(sortRandomNumbers());
            lottoDrawNumbers.add(lotto);
        }

        return lottoDrawNumbers;
    }

    private List<Integer> sortRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER_RANGE,
                MAX_NUMBER_RANGE,
                RANDOM_NUMBER_COUNT
        ));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
