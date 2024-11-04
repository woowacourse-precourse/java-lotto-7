package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Money;
import lotto.model.LottoInfo;

public class LottoInputView {
    public Money readMoneyInfo() {
        return readMoney();
    }

    public LottoInfo readLottoInfo() {
        return LottoInfo.map(
            readWinningNum(),
            readBonusNum()
        );
    }

    private Money readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return new Money(
            Integer.parseInt(input)
        );
    }

    private String readWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private String readBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
