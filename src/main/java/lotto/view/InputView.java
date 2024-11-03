package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.message.ErrorMessage;

public class InputView {

    /**
     * 사용자에게 구매 금액 입력 받기
     */
    public static String getPurchaseAmount() {
        return Console.readLine();
    }

    /**
     * 사용자에게 당첨 로또 번호 입력 받기
     */
    public static String getWinningLottoNumbers() {
        return Console.readLine();
    }

    /**
     * 사용자에게 보너스 번호 입력 받기
     */
    public static int getBonusNumber() {
        try{
            return Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e) {
            throw new InputException(ErrorMessage.UNAVAILABLE_TYPE_LOTTO_NUMBERS.getMessage());
        }
    }
}
