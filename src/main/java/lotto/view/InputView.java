package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoPurchasedAmountInput;

public class InputView {

    public LottoPurchasedAmountInput readLottoPurchasedAmount() {
        String RawAmount = Console.readLine();
        return LottoPurchasedAmountInput.from(RawAmount.trim());
    }
}
