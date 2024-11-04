package lotto.model;

import lotto.utils.Utils;
import lotto.validation.GlobalValidation;

import java.util.List;

import static lotto.Constants.*;
import static lotto.message.ErrorMessage.*;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumbersDuplicated(numbers);
        GlobalValidation.validateLottoNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_PICK_NUM) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_FIT_COUNT.getMessage());
        }
    }

    private void validateLottoNumbersDuplicated(List<Integer> numbers){
        if(GlobalValidation.hasDuplicate(numbers)){
            throw new IllegalArgumentException(LOTTO_NUMBERS_HAS_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int getWinningCount(List<Integer> winningNumbers){
        return Utils.countCommonElements(numbers, winningNumbers);
    }

    public int getBonusCount(int bonusNumber){
        if(hasBonusNumber(bonusNumber)){
            return 1;
        }
        return 0;
    }

    private boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
