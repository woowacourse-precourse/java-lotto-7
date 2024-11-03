package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateSize(numbers);
        Validator.validateDuplication(numbers);
        Validator.validateRange(numbers);
    }

    // TODO: 추가 기능 구현
    public static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
