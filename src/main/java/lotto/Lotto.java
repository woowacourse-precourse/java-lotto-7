package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private int bonusNumber = -1;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if(set.size() != 6) throw new IllegalArgumentException("[ERROR] 중복되는 수가 있습니다");
    }

    // TODO: 추가 기능 구현


    public void setBonusNumber(int bonusNumber) {
        if (bonusNumber <= 0) throw new IllegalArgumentException("[ERROR] 0보다 커야합니다.");
        if (numbers.contains(bonusNumber)) throw new IllegalArgumentException("[ERROR] 당첨 번호에 없는 번호여야 합니다.");

        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
