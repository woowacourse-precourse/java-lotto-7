package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String NOT_NUMBER = "[ERROR] 숫자가 아닌 값이 입력되었습니다.";
    private final String SEPARATOR = ",";

    public int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public List<Integer> getWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        try {
            return Arrays.stream(Console.readLine().split(SEPARATOR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public int getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
