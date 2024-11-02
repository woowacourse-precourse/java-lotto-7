package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.common.LottoConfig;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Set.copyOf(numbers);
    }

    public Set<Integer> getNumbers() {
        return Set.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_PICK_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (!isValidLottoNumberRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다.");
        }
        if (!isLottoNumberNotDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어선 안됩니다.");
        }
    }

    private boolean isValidLottoNumberRange(List<Integer> numbers) {
        return numbers.stream().filter(lottoNumber ->
                lottoNumber >= LottoConfig.LOTTO_MIN_NUMBER.getValue()
                        && lottoNumber <= LottoConfig.LOTTO_MAX_NUMBER.getValue()
        ).collect(Collectors.toList()).size() == numbers.size();
    }

    private boolean isLottoNumberNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == LottoConfig.LOTTO_PICK_COUNT.getValue();
    }
}
