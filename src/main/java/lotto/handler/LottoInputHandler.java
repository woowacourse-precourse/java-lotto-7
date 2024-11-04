package lotto.handler;

import java.util.List;
import lotto.view.InputView;

public class LottoInputHandler {
    public List<Integer> getWinningNumbers() {
        return InputView.getWinningNumbers();
    }

    public int getBonusNumber() {
        return InputView.getBonusNumber();
    }
}
