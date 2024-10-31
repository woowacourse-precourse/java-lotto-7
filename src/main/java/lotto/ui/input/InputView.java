package lotto.ui.input;

import java.util.List;

public interface InputView {

    int inputPayment();

    List<Integer> inputWinningNumbers();

    int inputBonusNumber();
}
