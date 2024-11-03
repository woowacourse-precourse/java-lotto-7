package lotto.controller;

import static lotto.utils.Parser.parseBonusNumber;
import static lotto.utils.Parser.parseWinningNumbers;
import static lotto.view.InputView.askBonusNumber;
import static lotto.view.InputView.askWinningNumbers;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

public class LottoDraw {
    public static WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = parseWinningNumbers(askWinningNumbers());
                return new WinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                return new BonusNumber(winningNumbers, parseBonusNumber(askBonusNumber()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
