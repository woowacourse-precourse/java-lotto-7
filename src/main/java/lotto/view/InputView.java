package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    /**
     * 로또 구입 금액의 입력을 요청한다.
     *
     * @return 입력받은 로또 구입 금액
     */
    public String getRequestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);
        return Console.readLine();
    }

    /**
     * 로또 당첨 번호의 입력을 요청한다.
     *
     * @return 입력받은 로또 당첨 번호
     */
    public String getRequestWinNumber() {
        System.out.println(REQUEST_WIN_NUMBER);
        return Console.readLine();
    }

    /**
     * 보너스 번호의 입력을 요청한다.
     *
     * @return 입력받은 보너스 번호
     */
    public String getRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
