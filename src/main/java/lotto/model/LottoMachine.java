package lotto.model;

import static lotto.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.exception.LottoErrorMessage.LOTTO_MONEY_INVALID_UNIT;
import static lotto.exception.LottoErrorMessage.LOTTO_MONEY_TOO_LOW;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoMachine {
    public List<Lotto> issueLottos(int money) {
        validateLottoMoney(money);

        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money / LOTTO_PRICE;
        while (lottoCount-- > 0) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                    LOTTO_NUMBER_COUNT);
            Lotto lotto = new Lotto(uniqueNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public HashMap<LottoPrice, Integer> calculateLottoPrice(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        HashMap<LottoPrice, Integer> prices = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean isBonusMatch = lotto.contains(bonusNumber);
            LottoPrice lottoPrice = LottoPrice.of(matchCount, isBonusMatch);
            prices.put(lottoPrice, prices.getOrDefault(lottoPrice, 0) + 1);
        }
        return prices;
    }

    private void validateLottoMoney(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_TOO_LOW.message);
        }
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_INVALID_UNIT.message);
        }
    }
}
