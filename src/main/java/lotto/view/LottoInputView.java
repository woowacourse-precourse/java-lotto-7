package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoInputView {
    public int validateMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money <= 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0보다 커야 합니다.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public int readMoney() {
        String input = Console.readLine();
        return validateMoney(input);
    }

    public List<Integer> validateWinningNumbers(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)로 구분해야 합니다.");
        }

        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> winningNumbers = convertToNumbers(numbers);
        validateNumbersRange(winningNumbers);
        validateNumbersDuplicate(winningNumbers);

        return winningNumbers;
    }

    private List<Integer> convertToNumbers(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        return validateWinningNumbers(input);
    }
    public int validateBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validateNumbersRange(List.of(bonusNumber));
            validateNotDuplicate(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
    private void validateNotDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
    public int readBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        return validateBonusNumber(input, winningNumbers);
    }
}