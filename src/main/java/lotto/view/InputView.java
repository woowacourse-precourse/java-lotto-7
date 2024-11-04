package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.RetryUtil;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String ENTER_PRICE = "구입금액을 입력해 주세요." + LINE_SEPARATOR;

    public Integer scanPrice() {
        return (Integer) RetryUtil.retryUntilSuccess(() -> {
            System.out.print(ENTER_PRICE);
            String input = Console.readLine();
            validatePrice(input);
            return Integer.parseInt(input);
        });
    }

    private void validatePrice(String input) {
        validateInteger(input);
        Integer price = Integer.parseInt(input);
        validateUnit(price);
    }

    private void validateInteger(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private void validateUnit(Integer price) {
        if(price%1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위로 입력해주세요.");
        }
    }
}
