package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import lotto.global.ErrorMessage;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static String getMoney() {
        System.out.println(INPUT_MONEY);
        return validateInput(InputValidator::validateMoney);
    }

    public static String getNumbers() {
        System.out.println(INPUT_NUMBERS);
        return validateInput(InputValidator::validateNumbers);
    }

    public static String getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER);
        return validateInput(rawInput -> InputValidator.validateBonusNumber(rawInput, winningNumbers));
    }

    private static String validateInput(Consumer<String> validator) {
        String input = readLine();
        try {
            validator.accept(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validateInput(validator);
        }
    }

    private static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException unsupported) {
            // 테스트 라이브러리는 NoSuch... 를 ignore 하기 때문에, 메시지만 출력하고 예외는 그대로 발생시킨다.
            System.out.println(ErrorMessage.NO_LINES_FOUND.getMessage());
            throw new NoSuchElementException(ErrorMessage.NO_LINES_FOUND.getMessage());
        }
    }
}
