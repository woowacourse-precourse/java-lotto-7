package lotto.domain;

import lotto.util.LottoNumberParser;
import lotto.validation.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateLotto(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }


    private List<Integer> validateLotto(List<Integer> numbers){
        LottoValidator.checkLottoNumberSize(numbers);
        LottoValidator.checkLottoNumberRange(numbers);

        return numbers;
    }

}
