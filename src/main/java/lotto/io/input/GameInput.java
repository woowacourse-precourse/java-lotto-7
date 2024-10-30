package lotto.io.input;

import java.util.List;
import lotto.LottoNumber;

public interface GameInput {
    int getPurchaseAmount();

    List<LottoNumber> getWinningNumbers();

    LottoNumber getBonusNumber();
}

