package lotto.io.inputHandler;

import java.util.List;

public interface InputHandler {

    int handlePurchaseCost();

    List<Integer> handleWinningNumbers();

    int handleBonusNumber();
}
