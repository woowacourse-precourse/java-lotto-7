package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputView {

    public Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(Console.readLine());
    }

}
