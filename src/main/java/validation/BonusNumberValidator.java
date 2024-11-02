package validation;

import constant.ErrorMessage;
import constant.LottoNumber;

public class BonusNumberValidator implements Validator<Integer>{

    @Override
    public void validate(Integer input) {
        if(input < LottoNumber.LOTTO_NUMBER_MIN.getLottoNumber()){
            throw new IllegalArgumentException(ErrorMessage.NOT_FIT_LOTTO_NUMBER_SCOPE.show());
        }
        if(input > LottoNumber.LOTTO_NUMBER_MAX.getLottoNumber()){
            throw new IllegalArgumentException(ErrorMessage.NOT_FIT_LOTTO_NUMBER_SCOPE.show());
        }
    }
}
