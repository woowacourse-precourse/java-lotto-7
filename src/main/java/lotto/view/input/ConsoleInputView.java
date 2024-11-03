package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import lotto.controller.error.ErrorType;

public class ConsoleInputView extends InputView {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요. (쉼표로 구분)";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    @Override
    protected String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        final String input = readLine();
        System.out.println();
        return input;
    }

    @Override
    protected List<String> inputWinningNumber() {
        System.out.println(WINNING_NUMBER_PROMPT);
        final String input = readLine();
        System.out.println();
        return split(input);
    }

    @Override
    protected String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        final String input = readLine();
        System.out.println();
        return input;
    }

    private String readLine() {
        return Console.readLine();
    }

    private List<String> split(final String numbers) {
        try {
            return Arrays.stream(numbers.split(DELIMITER, -1))
                    .toList();
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ErrorType.INVALID_DELIMITER.getMessage(), e);
        }
    }
}
