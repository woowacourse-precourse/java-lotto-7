package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNum;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setBonusNum(int bonusNum) {
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    // 당첨번호 입력 검증
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 번호를 입력하세요.");
        }

        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }
    }

    // 보너스 입력 검증
    private void validateBonusNum(int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }

        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않는 번호를 입력하세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
