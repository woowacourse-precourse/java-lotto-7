package lotto.domain;

import lotto.util.ParserToInt;
import lotto.validation.LottoNumberValidator;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    /**
     * 생성과 동시에 로또 번호가 적합한지 검증
     * @param numbers 로또 번호
     */
    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    /**
     * 문자열 보너스 번호를 정수형으로 변환하고 적합한 번호인지 검증
     * @param bonus 보너스 번호(문자열)
     */
    public void addBonusNumber(String bonus) {
        int bonusNumber = ParserToInt.parserToInt(bonus);
        LottoNumberValidator.validateBonusNumber(bonusNumber, numbers);
        numbers.add(bonusNumber);
    }

}
