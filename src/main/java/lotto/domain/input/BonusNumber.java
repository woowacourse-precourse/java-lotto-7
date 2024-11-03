package lotto.domain.input;

import lotto.domain.core.LottoNumber;

public class BonusNumber extends LottoNumber {

    public BonusNumber(int number) {
        super(number);

        super.valid();
    }
}
