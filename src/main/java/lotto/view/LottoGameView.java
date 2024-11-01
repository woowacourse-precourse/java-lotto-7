package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class LottoGameView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public String getMoneyInput(){
        return readLine().trim();
    }

    private static String readLine(){
        try {
            return Console.readLine();
        } catch (IllegalArgumentException e) {
            // error -> enum으로 관리
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
