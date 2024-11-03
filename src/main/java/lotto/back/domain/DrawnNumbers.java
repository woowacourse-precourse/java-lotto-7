package lotto.back.domain;

import java.util.List;
import lotto.global.exception.DuplicatedLottoNumberException;
import lotto.global.exception.InvalidLottoNumberCountException;

public class DrawnNumbers {
    private final List<LottoNumber> drawNumbers;

    public DrawnNumbers(List<Integer> drawNumbers) {
        validate(drawNumbers);
        this.drawNumbers = drawNumbers.stream().map(LottoNumber::new).toList();
    }

    private void validate(List<Integer> drawNumbers) {
        validateLottoNumberCount(drawNumbers);
        validateDuplication(drawNumbers);
    }

    private void validateLottoNumberCount(List<Integer> drawNumbers) {
        if (drawNumbers.size() != 6) {
            throw new InvalidLottoNumberCountException();
        }
    }

    private void validateDuplication(List<Integer> drawNumbers) {
        if (drawNumbers.stream().distinct().count() != drawNumbers.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }

    public List<Integer> getDrawnNumbers() {
        return drawNumbers.stream().map(LottoNumber::getLottoNumber).toList();
    }
}
