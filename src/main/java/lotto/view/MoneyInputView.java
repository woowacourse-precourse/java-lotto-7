package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class MoneyInputView {
    public static final String WRONG_FORMAT_MESSAGE = "숫자 형식으로 입력해주세요 혹은 숫자 입력 범위 최대를 넘으셨습니다.";

    public static Long getMoney() {
        try {
            String input = Console.readLine();
            Long money = Long.parseLong(input);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_FORMAT_MESSAGE);
        }
    }
}
