package module;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoDraw {

    public List<Integer> DrawNumbers(String input) {
        if (!isCorrectDelimiter(input)) {
            throw new IllegalArgumentException("쉼표(,)로 당첨번호을 구분해주세요.");
        }

        return convertToInteger(input);
    }

    private Boolean isCorrectDelimiter(String input) {
        return input.contains(",");
    }

    private List<Integer> convertToInteger(String input) {
        String[] inputNumbers = input.split(",");
        Set<Integer> drawNumbers = new HashSet<>();
        List<Integer> numbers = new ArrayList<>();

        for (int idx = 0; idx < inputNumbers.length; ++idx) {
            inputNumbers[idx] = inputNumbers[idx].trim();

            if (inputNumbers[idx].isEmpty()) {
                throw new IllegalArgumentException("당첨 번호는 공백이 될 수 없습니다.");
            }

            int number = Integer.parseInt(inputNumbers[idx]);


            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1~45 사이의 숫자여야 합니다.");
            }

            if (!drawNumbers.add(number)) {
                throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
            }

            numbers.add(number);
        }

        return numbers;
    }

    public Integer DrawBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonus = Integer.parseInt(input);

            if(bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자여야 합니다.");
            }

            if(winningNumbers.contains(bonus)) {
                throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }

            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야 합니다. " + input, e);
        }
    }
}
