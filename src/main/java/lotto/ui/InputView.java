package lotto.ui;

import java.util.List;

public interface InputView {
    String userInput();
    List<Integer> lottoWinningNumbers();
    String bonusNumber();
}
