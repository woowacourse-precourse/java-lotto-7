package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoDrawView {
    public String readDrawNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
