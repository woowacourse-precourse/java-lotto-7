package lotto.domain;

import lotto.util.ParserToInt;
import lotto.validation.LottoNumberValidator;

import java.util.List;

public class Lotto {

    public static final int BONUS_NUMBER_INDEX = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void addBonusNumber(String bonus) {
        int bonusNumber = ParserToInt.parserToInt(bonus);
        LottoNumberValidator.validateBonusNumber(bonusNumber, numbers);
        numbers.add(bonusNumber);
    }

}
