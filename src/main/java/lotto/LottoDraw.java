package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDraw {
    private int numberOfPurchases;
    private List<Lotto> lottoDrawNumbers;

    public LottoDraw(int purchaseAmount) {
        numberOfPurchases = purchaseAmount / 1000;
        lottoDrawNumbers = new ArrayList<>();
        randomLottoNumberDraw();
    }

    private void randomLottoNumberDraw() {
        for (int i = 0; i < numberOfPurchases; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoDrawNumbers.add(lotto);
        }
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public List<Lotto> getLottoDrawNumbers() {
        return lottoDrawNumbers;
    }
}
