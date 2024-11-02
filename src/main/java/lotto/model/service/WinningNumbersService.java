package lotto.model.service;

import java.util.List;
import lotto.model.WinningNumbers;
import lotto.view.InputView;

public class WinningNumbersService {
    private final WinningNumbers winningNumbers;
    private final InputView inputView;

    public WinningNumbersService(WinningNumbers winningNumbers, InputView inputView) {
        this.winningNumbers = winningNumbers;
        this.inputView = inputView;
    }

    public void inputWinningNumbers() {
        List<Integer> numbers = inputView.getWinningNumbers();
        winningNumbers.setWinningNumbers(numbers);
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
