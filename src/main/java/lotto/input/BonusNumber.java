package lotto.input;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber implements Input {

    private int bonusNumber;
    private List<Integer> numbers;

    public BonusNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(numbers);
    }

    @Override
    public void validate(String input) {
        validateInput(input);
        bonusNumber = Integer.parseInt(input);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위내 숫자여야 합니다.");
        }

        for (int number : numbers) {
            if (bonusNumber == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야합니다.");
            }
        }
    }

    private void validateInput(String input) {
        if (!input.matches("^[\\d]]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
