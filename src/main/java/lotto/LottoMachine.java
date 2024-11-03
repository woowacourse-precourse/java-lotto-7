package lotto;

import lotto.enums.ErrorCode;
import lotto.enums.Value;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoMachine {

    public static List<Lotto> lottoList;

    public void buyLotto(Long money) {
        validMoney(money);
        Long lottoCount = money / Value.lottoPrice;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = pickUniqueNumbersInRange(Value.lottoStartNumber, Value.lottoEndNumber, Value.lottoNumberCount);
            lottoList.add(new Lotto(lottoNumber));
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
}
