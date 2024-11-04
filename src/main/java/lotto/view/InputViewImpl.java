package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.checker.domain.BonusNumber;
import lotto.purchase.domain.Money;
import lotto.checker.domain.WinningNumbers;


public class InputViewImpl implements InputView {

    public Money getMoney() {
        while (true) {
            try {
                return new Money(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                return new BonusNumber(Console.readLine(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
