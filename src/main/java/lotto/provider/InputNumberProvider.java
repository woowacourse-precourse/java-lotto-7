package lotto.provider;

import lotto.util.RetryHandler;
import lotto.view.InputView;

import java.util.List;

public class InputNumberProvider implements NumberProvider {

    @Override
    public List<Integer> getNumbers() {
        return RetryHandler.retryUntilSuccess(() -> InputView.getWinningNums());
    }
}
