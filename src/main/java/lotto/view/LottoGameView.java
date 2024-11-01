package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class LottoGameView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public String getMoneyInput() {
        System.out.println(INPUT_MONEY);
        
        return Console.readLine().trim();
    }
}
