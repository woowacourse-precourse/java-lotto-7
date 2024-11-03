package lotto;

import lotto.enums.Value;

public class LottoMachine {

    public void buyLotto(Long money) {
        validMoney(money);
        Long lottoCount = money / Value.lottoPrice;

    }

    private void validMoney(Long money) {
        if (money < Value.lottoPrice) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 1000원입니다.");
        }
        if (money % Value.lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.");
        }
    }
}
