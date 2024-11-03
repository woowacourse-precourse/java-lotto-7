package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 1,000원 단위로 입력해주세요.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    public List<Integer> parseNumbers(String[] numbers) {
        List<Integer> tempNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i].trim());
            validateNumber(number);
            tempNumbers.add(number);
        }
        return tempNumbers;
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateBonusNumber(int number, List<Integer> winningNumbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
