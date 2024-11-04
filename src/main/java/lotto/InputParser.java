package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String DELIMITER = ",";
    private final InputValidate validator;

    public InputParser(InputValidate validator) {
        this.validator = validator;
    }

    public int parsePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input.trim());
            validator.validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 올바른 숫자 형식이어야 합니다.");
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
        try {
            List<Integer> winningNumbers = Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validator.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 올바른 숫자 형식이어야 합니다.");
        }
    }

    public int parseBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            validator.validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 올바른 숫자 형식이어야 합니다.");
        }
    }
}
