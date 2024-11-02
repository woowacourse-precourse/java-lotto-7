package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto create() {
        List<Integer> numbers = getLottoNumber();
        numbers.sort(Integer::compareTo);
        return new Lotto(numbers);
    }

    public static Lotto WinningLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> add(int number) {
        List<Integer> newNumbers = new ArrayList<>(numbers);
        newNumbers.add(number);
        return newNumbers;
    }

    public static List<Integer> setBonusNumber(Lotto winningLotto, int number) {
        return winningLotto.add(number);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumber(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumber(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private static List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}