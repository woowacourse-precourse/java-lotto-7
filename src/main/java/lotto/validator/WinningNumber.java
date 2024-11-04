package lotto.validator;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber implements InputTypeValidator{
    private final List<String> numbers;

    public WinningNumber(String winningNumber) {
        List<String> numbers = List.of(winningNumber.split(",", -1));
        this.numbers = numbers;
    }

    public boolean isDelimitedByComma() {
        try {
            for (String number : numbers) {
                Integer.parseInt(number);
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 숫자를 입력해 주세요.");
        }
    }

    @Override
    public boolean isNaturalNumber() {
        for (String number : numbers) {
            if (1 > Integer.parseInt(number) || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1이상 45이하 자연수로 입력해 주세요.");
            }
        }
        return true;
    }

    public boolean isSameNumber() {
        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6 || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6개의 숫자를 입력해 주세요.");
        }
        return true;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
