package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnerNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinnerNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45사이의 번호여야 합니다.");
            }
        }
        Set<Integer> s = new HashSet<>();
        for (Integer number : numbers) {
            if(!s.add(number)){
                throw new IllegalArgumentException(
                        String.format("[ERROR] 중복된 번호가 있습니다: (%d).", number)
                );
            }
        }

        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 번호여야 합니다.");
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안됩니다.");
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
