package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        this.bonusNumber = pickBonusNumber(numbers);
        validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers; // 생성된 로또 번호 목록을 반환
    }

    private int pickBonusNumber(List<Integer> numbers) {
        int bonus = Randoms.pickUniqueNumbersInRange(1, 45, 1).get(0);
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
        return bonus;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1번부터 45번 사이여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
