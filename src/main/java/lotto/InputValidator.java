package lotto;

import java.util.LinkedList;
import java.util.List;

public class InputValidator {

    public int validateAmount(String input) {
        input = checkNotEmpty(input);
        int amount = Integer.parseInt(input);
        validatePositiveAmount(amount);
        validateAmountInThousands(amount);
        return amount;
    }

    public List<Integer> validateWinningNumbers(String input) {
        input = checkNotEmpty(input);
        String[] numbers = splitByComma(input);
        List<Integer> numberList= convertToInteger(numbers);
        validateRange(numberList);
        return numberList;
    }

    public int validateBonusNumber(String input) {
        input = checkNotEmpty(input);
        int number = checkIfInteger(input);
        validateRange(number);
        return number;
    }



    private String checkNotEmpty(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
        }
        return input;
    }

    // 여기서 부터는 구입 금액을 검증
    private void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0 이상 이어야 합니다.");
        }
    }

    private void validateAmountInThousands(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    //  regex pattern \\s*을 사용하면 쉼표 주변의 whitespace는 무시하고 String을 나눈다
    private String[] splitByComma(String input) {
        String[] array;
        try {
            array = input.split("\\s*,\\s*");
        } catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 번호를 쉼표(,)를 사용해 구분해 주세요.");
        }
        return array;
    }

    private List<Integer> convertToInteger(String[] numbers) {
        List<Integer> list = new LinkedList<>();
        for (String num : numbers) {
            checkIfInteger(num);
            list.add(Integer.parseInt(num));
        }
        return list;
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45이하의 정수여야 합니다.");
        }
    }

    private int checkIfInteger(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("보너스 숫자는 정수여야 합니다.");
        }
        return number;
    }

}
