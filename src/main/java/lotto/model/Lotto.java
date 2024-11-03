package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Constant.LottoRule.*;
import static lotto.Exception.CommonErrorCode.OUT_OF_RANGE;
import static lotto.Exception.LottoNumber.LottoNumberInputErrorCode.INCORRECT_NUMBER_COUNT;
import static lotto.Exception.LottoNumber.LottoNumberInputErrorCode.NUMBER_MUST_NOT_DUPLICATE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateBonusBall(int num){
        validateNumArrange(num);
    }

    private void validate (List<Integer> numbers) {
        validateNumberLength(numbers);
        validateLottoNumArrange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNT.getArgsErrorMessage(LOTTO_COUNT));
        }
    }

    private void validateLottoNumArrange (List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            validateNumArrange(numbers.get(i));
        }
    }

    private void validateNumArrange(int number){
        if(number<MIN_NUM || number>MAX_NUM) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getArgsErrorMessage(LOTTO_NUMBER, MIN_NUM, MAX_NUM));
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_MUST_NOT_DUPLICATE.getArgsErrorMessage(LOTTO_NUMBER));
        }
    }

    private void validateNoDuplicatesWithBonusBall(int bonusBall){
        if(numbers.contains(bonusBall)){
            throw new IllegalArgumentException(NUMBER_MUST_NOT_DUPLICATE.getArgsErrorMessage(BONUS_NUMBER));
        }
    }

}
