package lotto.io.input;

import java.util.List;
import lotto.domain.BonusNumber;

public interface GameInput {
    int getPurchaseAmount();

    List<Integer> getWinningNumbers();

    BonusNumber getBonusNumber();
}

