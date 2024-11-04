package object;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinNumber {
    private final List<Integer> winNumbers;

    public WinNumber(List<Integer> winNumbers) {
        validate(winNumbers);
        DuplicateValidate(winNumbers);
        this.winNumbers = winNumbers;
    }

    private void validate(List<Integer> winNumbers) {
        for (Integer winNumber : winNumbers) {
            if (winNumber < 1 || winNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void DuplicateValidate(List<Integer> winNumbers) {
        Set<Integer> duplicateValidate = new HashSet<>();

        for (Integer winNumber : winNumbers) {
            if (!duplicateValidate.add(winNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
        }
    }
}
