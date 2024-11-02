package lotto.io;

import lotto.lotto.LottoNumber;
import lotto.lotto.WiningNumbers;

public interface InputHandler {

    int inputPurchaseAmount();

    WiningNumbers inputWiningNumbers();

    LottoNumber inputBonusNumber();
}
