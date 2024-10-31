package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numberCountValidate(numbers);
        overlapValidate(numbers);
    }

    private void numberCountValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호(보너스 번호 제외)는 6개여야 합니다.");
        }
    }

    private void overlapValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
        }
    }

    public void setBonusNumber(int bonusNumber) {
        bonusNumberValidate(bonusNumber);
        numbers.add(bonusNumber);
    }

    private void bonusNumberValidate(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복되면 안됩니다.");
        }
    }
}
