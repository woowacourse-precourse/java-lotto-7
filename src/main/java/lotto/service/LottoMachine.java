package lotto.service;

import lotto.Lotto;
import lotto.constants.ErrorCode;
import lotto.constants.Value;
import lotto.data.Database;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoMachine {

    public void buyLotto(Long money) {
        validMoney(money);
        Long lottoCount = money / Value.lottoPrice;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = pickUniqueNumbersInRange(Value.lottoStartNumber, Value.lottoEndNumber, Value.lottoNumberCount);
            Database.purchaseLottoList.add(new Lotto(lottoNumber));
            System.out.println(lottoNumber);
        }
    }

    private void validMoney(Long money) {
        if (money < Value.lottoPrice) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_MIN_PRICE_ERROR.getMessage());
        }
        if (money % Value.lottoPrice != 0) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_PRICE_ERROR.getMessage());
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return Database.purchaseLottoList;
    }
}
