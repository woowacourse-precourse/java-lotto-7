package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.common.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.model.Budget;

public class InputView {
    private static final String INPUT_BUDGET_INFO = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_INFO = "당첨 번호를 입력해 주세요.";
    private static final String WINING_NUMBER_DELIMITER = ",";
    private static final String INPUT_BONUS_NUMBER_INFO = "보너스 번호를 입력해 주세요.";

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
            System.out.println(ErrorMessage.BUDGET_NUMBER_FORMAT.message());
            return readBudget();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBudget();
        }
    }

    public WinningLotto readWinningLotto() {
        Lotto lotto = readWinningNumbers();
        return lotWinningLotto(lotto);
    }

    private WinningLotto lotWinningLotto(Lotto lotto) {
        try {
            return WinningLotto.of(lotto, readBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lotWinningLotto(lotto);
        }
    }

    private Lotto readWinningNumbers() {
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
            System.out.println(ErrorMessage.BUDGET_NUMBER_FORMAT.message());
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
            throw new IllegalArgumentException(ErrorMessage.WINING_NUMBER_DELIMITER.message());
        }
        return Arrays.stream(input.split(WINING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private int readBonusNumber() {
        String input = promptForBonusNumber();
        return parseBonusNumber(input);
    }

    private String promptForBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_INFO);
        return Console.readLine();
    }

    private int parseBonusNumber(String input) {
        try {
            if (input == null) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_NOT_NULL.message());
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.BUDGET_NUMBER_FORMAT.message());
            return readBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber();
        }
    }

}
