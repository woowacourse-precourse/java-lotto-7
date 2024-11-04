package lotto.model;

import lotto.dto.WinningNumberDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    private static final String DELIMITER = ",";

    private final Lotto lotto;
    private final int bonus;

    public WinningNumber(String numbers, int bonus) {
        this.lotto = createLotto(numbers);
        validateUniqueBonus(bonus);
        validateBonusRange(bonus);
        this.bonus = bonus;
    }

    private Lotto createLotto(String input) {
        List<Integer> numbers = Stream.of(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateFormat(input, numbers.size());
        return new Lotto(numbers);
    }

    private void validateFormat(String numbers, int size) {
        int count = numbers.length() - numbers.replace(DELIMITER, "").length();
        if (count + 1 != size) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
        }
    }

    private void validateUniqueBonus(int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복일 수 없습니다.");
        }
    }

    private void validateBonusRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45사이 여야 합니다.");
        }
    }

    public WinningNumberDto toWinningNumberDto() {
        return new WinningNumberDto(lotto, bonus);
    }
}
