package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateUniqueNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoConstant.LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LottoConstant.LOTTO_NUMBER_MIN_RANGE
                || number > LottoConstant.LOTTO_NUMBER_MAX_RANGE)) {
            throw new IllegalArgumentException("[ERROR] 유효한 범위의 숫자가 아닙니다.");
        }
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(numbers);
    }

    public int countMatchingNumbers(LottoAnswer lottoAnswer) {
        return (int) numbers.stream()
                .filter(lottoAnswer::containsNumber)
                .count();
    }

    public boolean matchesBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isSameAsAny(numbers);
    }

}
