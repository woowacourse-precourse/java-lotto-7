package lotto.io;

import java.util.List;

public interface InputHandler {

    int getLottoPurchaseFromUser();

    List<Integer> getWinningNumbersFromUser();

    int getBonusNumberFromUser(List<Integer> winningNumbers);
}
