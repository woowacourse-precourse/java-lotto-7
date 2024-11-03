package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDraw {
    private final int LOTTO_PRICE = 1000;
    private final int MIN_NUMBER_RANGE = 1;
    private final int MAX_NUMBER_RANGE = 45;
    private final int RANDOM_NUMBER_COUNT = 6;

    private int numberOfPurchases;
    private List<Lotto> lottoDrawNumbers;

    public LottoDraw(int purchaseAmount) {
        numberOfPurchases = purchaseAmount / LOTTO_PRICE;
        lottoDrawNumbers = new ArrayList<>();
        randomLottoNumberDraw();
    }

    private void randomLottoNumberDraw() {
        for (int i = 0; i < numberOfPurchases; i++) {
            Lotto lotto = new Lotto(sortRandomNumbers());
            lottoDrawNumbers.add(lotto);
        }
    }

    private List<Integer> sortRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER_RANGE,
                MAX_NUMBER_RANGE,
                RANDOM_NUMBER_COUNT
        );
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public List<Lotto> getLottoDrawNumbers() {
        return lottoDrawNumbers;
    }
}
