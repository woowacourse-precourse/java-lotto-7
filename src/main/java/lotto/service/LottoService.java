package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_CNT = 6;

    private Lotto generateLotto() {
        List<LottoNumber> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER,
                        NUMBER_CNT)
                .stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(numbers);
    }

    public int calculateLottoCount(int amount) {
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 음수일 수 없습니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
