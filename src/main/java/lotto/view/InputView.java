package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.model.Budget;

public class InputView {
    private static final String INPUT_BUDGET_INFO = "구입금액을 입력해 주세요.";
    private static final String ERROR_BUDGET_NUMBER_FORMAT = "[ERROR] 금액은 숫자로 입력해주세요.";
    private static final String INPUT_WINNING_NUMBERS_INFO = "당첨 번호를 입력해 주세요.";
    private static final String ERROR_WINING_NUMBER_DELIMITER= "[ERROR] 당첨번호는 ','로 구분된 6개의 숫자여야 합니다.";
    private static final String WINING_NUMBER_DELIMITER = ",";

    public Budget readBudget() {
        String input = promptForBudget();
        return makeBudget(input);
    }

    private String promptForBudget() {
        System.out.println(INPUT_BUDGET_INFO);
        return Console.readLine();
    }

    private Budget makeBudget(String input) {
        try {
            Long amount = Long.parseLong(input);
            return Budget.of(amount);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_BUDGET_NUMBER_FORMAT);
            return readBudget();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBudget();
        }
    }

    public Lotto readWinningNumbers() {
        String input = promptForWinningNumbers();
        return makeWinningLotto(input);
    }

    private String promptForWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_INFO);
        return Console.readLine();
    }

    private Lotto makeWinningLotto(String input) {
        try {
            List<Integer> numbers = parseIntegerList(input);
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_BUDGET_NUMBER_FORMAT);
            return readWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    private List<Integer> parseIntegerList(String input) {
        if (input == null || input.isBlank()) {
            return Collections.emptyList();
        }
        if (!input.contains(WINING_NUMBER_DELIMITER)) {
            throw new IllegalArgumentException(ERROR_WINING_NUMBER_DELIMITER);
        }
        return Arrays.stream(input.split(WINING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
