package lotto.model;

import lotto.common.ExceptionConstant;
import lotto.common.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE + ExceptionConstant.LOTTO_NUMBER_MESSAGE + LottoConstant.LOTTO_SIZE + "개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE + ExceptionConstant.LOTTO_NUMBER_MESSAGE + "중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
