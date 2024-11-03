package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 사용자에게 구매 금액 입력 받기
     */
    public static String getPurchaseAmount() {
        return Console.readLine();
    }

    /**
     * 사용자에게 로또 번호 입력 받기
     */
    public static String getLottoNumbers() {
        return Console.readLine();
    }

}
