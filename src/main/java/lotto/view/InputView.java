package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 사용자에게 구매 금액 입력 받기
     */
    public static String readPurchaseAmount() {
        return Console.readLine();
    }

    /**
     * 사용자에게 당첨 로또 번호 입력 받기
     */
    public static String readWinningLottoNumbers() {
        return Console.readLine();
    }

    /**
     * 사용자에게 보너스 번호 입력 받기
     */
    public static String readBonusNumber() {
        return Console.readLine();
    }
}
