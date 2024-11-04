package lotto.input;

import java.util.List;
import lotto.domain.Lotto;

public interface InputHandler {

    int readPurchaseAmount();

    List<Integer> readWinningNumbers();

    int readBonusNumber(Lotto winningLotto);
}
