package lotto.io;

import lotto.lotto.LottoAmount;
import lotto.lotto.LottoNumber;
import lotto.lotto.WiningNumbers;

public interface InputHandler {

    LottoAmount inputPurchaseAmount();

    WiningNumbers inputWiningNumbers();

    LottoNumber inputBonusNumber();
}
