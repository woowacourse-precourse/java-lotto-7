package lotto.console.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import lotto.console.domain.InputValidator;

public class InputView {

    public int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();

        validateMoney(input);

        return Integer.parseInt(input);
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 없습니다.");
        } finally {
            Console.close();
        }
    }

    private void validateMoney(String input) {
        if (!InputValidator.MONEY.check(input)) {
            throw new IllegalArgumentException("[ERROR] 입력은 양수여야 합니다.");
        }
    }

    public List<Integer> readWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();

        validateWinNumbers(input);

        return parseNumbers(input);
    }

    private void validateWinNumbers(String input) {
        if (!InputValidator.WIN_NUMBERS.check(input)) {
            throw new IllegalArgumentException("[ERROR] 입력은 쉼표로 구분된 6개의 양수여야 합니다.");
        }
    }

    private List<Integer> parseNumbers(String input) {
        String[] numbers = input.split(",");

        return Stream.of(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public Integer readBonusNumber() {
        System.out.println("보너스 번호을 입력해 주세요.");
        String input = readLine();

        validateBonusNumber(input);

        return Integer.parseInt(input);
    }

    private void validateBonusNumber(String input) {
        if (!InputValidator.BONUS_NUMBER.check(input)) {
            throw new IllegalArgumentException("[ERROR] 입력은 양수여야 합니다.");
        }
    }
}
