package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private int lottoNumberOfPurchases;


    public void calculateNumberOfPurchases(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다. 확인 바랍니다.");
        }
        lottoNumberOfPurchases = money / LOTTO_PRICE;
    }

    public List<Integer> createLottoNumbers () {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return integers;
    }


    public int getLottoNumberOfPurchases() {
        return lottoNumberOfPurchases;
    }
}
