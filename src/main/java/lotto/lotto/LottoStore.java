package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoStore {
    private static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 입력 값 입니다. 확인 바랍니다.";
    private static final int LOTTO_PRICE = 1000;
    private int lottoNumberOfPurchases;

    public void calculateNumberOfPurchases(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
        lottoNumberOfPurchases = money / LOTTO_PRICE;
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getLottoNumberOfPurchases() {
        return lottoNumberOfPurchases;
    }
}