package lotto.controller;

import static lotto.utils.Parser.parseStringToInteger;
import static lotto.utils.Parser.parseStringToIntegerList;
import static lotto.view.InputView.readBonusNumber;
import static lotto.view.InputView.readWinningNumbers;

import java.util.List;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

public class LottoAnswerGenerator {
    public static WinningNumbers askWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = readWinningNumbers();
                List<Integer> parsedWinningNumbers = parseStringToIntegerList(winningNumbersInput);
                return new WinningNumbers(parsedWinningNumbers);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber askBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = readBonusNumber();
                Integer parsedBonusNumber = parseStringToInteger(bonusNumberInput);

                BonusNumber bonusNumber = new BonusNumber(winningNumbers.getWinningNumbers(), parsedBonusNumber);

                return bonusNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
