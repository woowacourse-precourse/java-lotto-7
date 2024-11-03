package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();
        return convertToInt(money);
    }

    public String inputLottoNumber() {
        System.out.println(System.lineSeparator() + LOTTO_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(System.lineSeparator() + BONUS_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    private int convertToInt(final String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_CONVERT_TO_INT.getMessage());
        }
    }
}
