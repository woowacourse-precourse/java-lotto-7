package lotto.model;

import static lotto.model.constant.LottoConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateLottoNumber(numbers);
        validateLottoNumbersRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        if (countDistinctUniqueNumbers(numbers) != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumberRange);
    }

    private void validateLottoNumberRange(Integer number) {
        if (!isLottoNumberRange(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자 입니다.");
        }
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private long countDistinctUniqueNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
