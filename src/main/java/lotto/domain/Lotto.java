package lotto.domain;

import lotto.util.LottoNumberParser;
import lotto.validation.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String numbers) {
        this.numbers = validateLotto(parseToInt(numbers));
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private List<Integer> parseToInt(String numbers){
        return LottoNumberParser.parseLottoNumbers(numbers);
    }

    private List<Integer> validateLotto(List<Integer> numbers){
        LottoValidator.checkLottoNumberSize(numbers);
        LottoValidator.checkLottoNumberRange(numbers);

        return numbers;
    }

}
