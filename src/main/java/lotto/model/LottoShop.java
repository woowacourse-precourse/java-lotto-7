package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_PRICE;
import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExactChangeNotPossibleException;

public class LottoShop {


    public Lottos buy(Integer price) {
        validatePrice(price);
        return generateLottos(calculateBuyCount(price));
    }

    private Lottos generateLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private int calculateBuyCount(Integer price) {
        return price / LOTTO_PRICE;
    }

    public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
    }

    private void validatePrice(Integer price) {
        if (!isExactChangePossible(price)) {
            throw new ExactChangeNotPossibleException();
        }
    }

    private boolean isExactChangePossible(Integer price) {
        return price % LOTTO_PRICE == 0;
    }

}
