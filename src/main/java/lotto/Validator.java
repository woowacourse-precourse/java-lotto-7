package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }
    public List<Integer> validateWinningNumbers(String[] input) {
        if (input.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : input) {
            number = number.trim();
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 1 || parsedNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.contains(parsedNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 숫자를 입력할 수 없습니다.");
            }
            winningNumbers.add(parsedNumber);
        }
        return winningNumbers;
    }
    public void validateBonus(String bonus) {
        if (!bonus.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        int bonusNumber = Integer.parseInt(bonus);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
