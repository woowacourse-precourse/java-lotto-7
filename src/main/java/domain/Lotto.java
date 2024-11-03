package domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sameNumberInLotto(numbers);
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        sortLotto(sortNumbers);
        this.numbers = sortNumbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void sameNumberInLotto(List<Integer> numbers) {
        Set<Integer> setLottoNumbers = new HashSet<>(numbers);
        if(setLottoNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.");
        }
    }

    public static void sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
