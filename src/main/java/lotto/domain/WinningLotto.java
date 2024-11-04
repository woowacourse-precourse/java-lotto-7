package lotto.domain;

import lotto.util.BonusNumberParser;
import lotto.util.WinningLottoParser;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;


    public WinningLotto(String input, String bonusNumberInput) {
        List<Integer> parsedNumbers = WinningLottoParser.parseWinningNumbers(input);
        int parsedBonusNumber = BonusNumberParser.toIntStringBonusNumberParser(bonusNumberInput);

        validateNumbers(parsedNumbers);
        validateBonusNumber(parsedNumbers, parsedBonusNumber);

        this.numbers = parsedNumbers;
        this.bonusNumber = parsedBonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
