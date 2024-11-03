package lotto;

import static lotto.LottoConstant.*;

public class LottoFactory {

    public void createByCount(int count) {
        Lotto lotto = new Lotto(RandomNumbersCreator.create(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT));
    }
}
