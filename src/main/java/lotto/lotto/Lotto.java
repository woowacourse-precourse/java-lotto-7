package lotto.lotto;

import java.util.List;
import lotto.io.output.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        LottoValidator.validateLottoNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    public void validateNoDuplicateWithBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
