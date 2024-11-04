package lotto.model;

import static lotto.validator.Validator.validateNumberCount;
import static lotto.validator.Validator.validateNumberDuplicate;
import static lotto.validator.Validator.validateNumberRange;

import java.util.List;
import lotto.model.enums.WinningType;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);

        validateNumberRange(numbers);

        validateNumberDuplicate(numbers);
    }

    public WinningType checkWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        int matchCount = 0;
        boolean matchBonus = false;
        matchCount += matchNumbers(winningNumbers);
        matchBonus = matchBonus(bonusNumber);

        return WinningType.getWinningType(matchCount, matchBonus);
    }

    private Integer matchNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : numbers) {
            matchCount += isMatched(winningNumbers, number);
        }
        return matchCount;
    }

    private Integer isMatched(List<Integer> winningNumbers, Integer number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private boolean matchBonus(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public String toPrintList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (numbers.size() > 0) {
            stringBuilder.append(numbers.get(0));
        }
        for (int i = 1; i < numbers.size(); i++) {
            stringBuilder.append(", " + numbers.get(i));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
