package lotto;


import static lotto.Validator.promptWithValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView() {

    }

    public static int getValidPurchasePrice() {
        return promptWithValidation("구입금액을 입력해 주세요.", validatePurchasePrice());
    }

    public static List<Integer> getValidWinningNumbers() {
        return promptWithValidation("당첨 번호를 입력해 주세요.", validateWinningNumbers());
    }

    public static int getValidBonusNumber(List<Integer> winningNumbers) {
        return promptWithValidation("보너스 번호를 입력해 주세요.",
                input -> validateBonusNumber(input, winningNumbers));
    }

    private static Validator<Integer> validatePurchasePrice() {
        return (input) -> {
            checkNonEmptyNumeric(input);
            int price = Integer.parseInt(input);
            if (price % 1000 != 0 || price < 1000) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이며, 1000원 단위로 나누어 떨어져야 합니다.");
            }
            return price;
        };
    }

    private static Validator<List<Integer>> validateWinningNumbers() {
        return (input) -> {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (numbers.size() != 6 || numbers.stream().distinct().count() != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않은 6개의 숫자여야 합니다.");
            }
            numbers.forEach(InputView::validateLottoNumberRange);
            return numbers;
        };
    }

    private static void checkNonEmptyNumeric(String input) {
        if (input == null || input.isEmpty() || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    private static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        checkNonEmptyNumeric(input);
        int number = Integer.parseInt(input);
        validateLottoNumberRange(number);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return number;
    }


    private static void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
