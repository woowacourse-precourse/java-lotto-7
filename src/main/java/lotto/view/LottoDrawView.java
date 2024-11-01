package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoDrawView {
    public String getDrawNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
