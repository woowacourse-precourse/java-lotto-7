package lotto.model;

import lotto.constant.Constant;

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
        if (numbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.LOTTO_NUMBER_MESSAGE  + Constant.LOTTO_SIZE + "개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.LOTTO_NUMBER_MESSAGE + "중복될 수 없습니다.");
        }
    }

}
