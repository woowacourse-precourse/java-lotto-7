package lotto.domain;

import lotto.util.ParserToInt;
import lotto.validation.LottoNumberValidator;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public void addBonusNumber(String bonus) {
        int bonusNumber = ParserToInt.parserToInt(bonus);
        LottoNumberValidator.validateBonusNumber(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

}
