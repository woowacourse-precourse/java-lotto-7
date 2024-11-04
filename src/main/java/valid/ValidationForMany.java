package valid;

import java.util.Arrays;
import java.util.List;

public class ValidationForMany {
    public boolean consistOfOnlySixPositiveNumbers(String winningNumbers) {
        List<String> numbers = Arrays.stream(winningNumbers.split(",")).toList();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        try {
            numbers.forEach(Integer::parseInt);
        } catch (NumberFormatException ie) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로만 구성되어야 합니다.");
        }

        if (numbers.stream().anyMatch(number -> Integer.parseInt(number) <= 0)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 0보다 큰 숫자여야 합니다.");
        }

        return true;
    }
}
