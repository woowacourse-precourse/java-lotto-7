package lotto.domain;

import static lotto.domain.LottoNumber.LOTTO_MAX_VALUE;
import static lotto.domain.LottoNumber.LOTTO_MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    public static final String LOTTO_SIZE_ERROR_MSG
            = String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LOTTO_SIZE);
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
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_SIZE));
    }

    public boolean hasBonusNumber(BonusNumber number) {
        return numbers.contains(number);
    }

    public String retrieveLottoNumber() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MSG);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MSG);
        }
    }

    /*
     * Getter
     * */
    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
