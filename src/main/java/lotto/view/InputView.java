package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class InputView {

    public Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(Console.readLine());
    }

    public WinningNumbers getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return new WinningNumbers(Console.readLine());
    }

    public BonusNumber getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return new BonusNumber(Console.readLine());
    }

}
