package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoSizeException;
import lotto.exception.message.Error;

public class Lotto {

    private static final int FIX_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != FIX_SIZE) {
            throw new LottoSizeException(FIX_SIZE);
        }
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        Set<LottoNumber> removalDuplication = new HashSet<>(numbers);

        if (numbers.size() != removalDuplication.size()) {
            throw new LottoNumberException(Error.DUPLICATED_NUMBER);
        }
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.contains(number);
    }
    
    public List<Integer> getNumberValues() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
