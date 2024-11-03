package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import lotto.service.LottoGenerator;
import lotto.util.ValidationUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        ValidationUtil.validateNumberCount(numbers);
        ValidationUtil.validateRange(numbers);
        ValidationUtil.validateNoDuplicates(numbers);

    }

    // TODO: 추가 기능 구현

    public static Lotto generateLottoNumber() {
        final List<Integer> generatedNumbers = LottoGenerator.generateLottoNumbers();
        return new Lotto(generatedNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
