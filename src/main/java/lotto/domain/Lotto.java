package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final String LOTTO_SIZE_ERROR_MSG = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_DUPLICATE_ERROR_MSG = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .toList();
    }

    public static Lotto issue() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public boolean hasBonusNumber(BonusNumber number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MSG);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MSG);
        }
    }

    public String retrieveLottoNumber() {
        return numbers.toString();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
