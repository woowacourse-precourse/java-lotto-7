package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInputView {

    private static final String FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요 혹은 입력 최대치를 입력하셨습니다.";

    public static int getBonusNumber() {
        String number = Console.readLine();
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }
}
