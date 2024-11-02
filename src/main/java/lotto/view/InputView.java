package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return readLine();
    }

    public String getLottoNumbers() {
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
        return readLine();
    }

    public String getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return readLine();
    }

    private String readLine() {
        String rawInput = Console.readLine();
        if (rawInput == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
        return rawInput.trim();
    }
}
