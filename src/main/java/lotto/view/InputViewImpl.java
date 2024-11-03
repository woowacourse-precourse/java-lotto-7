package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;


public class InputViewImpl implements InputView {

    public Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return new Money(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                return new WinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                return new BonusNumber(Console.readLine(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
