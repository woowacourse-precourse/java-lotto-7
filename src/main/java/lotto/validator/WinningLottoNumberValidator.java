package lotto.validator;

import lotto.exception.LottoException;
import lotto.model.lotto.LottoConstant;

import java.util.Set;

public class WinningLottoNumberValidator {

    private final Set<Integer> winningLottoNumbers;

    public WinningLottoNumberValidator(Set<Integer> winningLottoNumbers){
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public void validateAll(){
        validateRange();
        validateCount();
    }

    private void validateRange(){
        winningLottoNumbers.stream()
                .filter(num -> num < LottoConstant.NUMBER_START_INCLUSIVE || num > LottoConstant.NUMBER_END_INCLUSIVE)
                .findFirst()
                .ifPresent(num -> {
                    throw new IllegalArgumentException(LottoException.INVALID_RANGE.getMessage());
                });
    }

    private void validateCount(){
        if (winningLottoNumbers.size() != LottoConstant.NUMBER_COUNT){
            throw new IllegalArgumentException(LottoException.INVALID_COUNT.getMessage());
        }
    }

    public void validateBonusNumber(int bonusNumber){
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoException.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

}
