package lotto.handler;

import lotto.domain.WinningNumbers;

import static lotto.view.RequestView.getInputNumbers;


public class WinningNumbersInputHandler {
    public WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = getInputNumbers();
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
