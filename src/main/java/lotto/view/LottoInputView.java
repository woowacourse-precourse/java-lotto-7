package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class LottoInputView {
    public int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return Integer.parseInt(input.trim());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseWinningNumbers(input);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseBonusSingleNumber(input);
    }

    private List<Integer> parseWinningNumbers(String input) {
        validateWinningNumbersInput(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(num -> !num.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private int parseBonusSingleNumber(String input) {
        validateBonusSingleNumberInput(input);
        return Integer.parseInt(input.trim());
    }

    private void validatePurchaseAmount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값은 비어 있을 수 없습니다.");
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("구입 금액은 숫자만 포함되어야 하며, 공백이 포함될 수 없습니다.");
        }
    }

    private void validateWinningNumbersInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값은 비어 있을 수 없습니다.");
        }
        if (!input.matches("[\\d,\\s]*")) {
            throw new IllegalArgumentException("입력 값은 숫자와 쉼표로만 이루어져야 합니다.");
        }
        if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다. 예) 1, 2, 3, 4, 5, 6");
        }
    }

    private void validateBonusSingleNumberInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값은 비어 있을 수 없습니다.");
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 포함되어야 합니다.");
        }
    }
}
