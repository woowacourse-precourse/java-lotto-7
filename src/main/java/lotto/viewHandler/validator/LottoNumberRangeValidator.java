package lotto.viewHandler.validator;

import lotto.viewHandler.Validator;
import lotto.viewHandler.exception.NotLottoNumberRange;

public class LottoNumberRangeValidator implements Validator<Void, Integer> {
    @Override
    public Void validate(Integer input) {
        if(input <= 1 || input >= 45) {
            throw new NotLottoNumberRange("로또 넘버가 1 ~ 45 사이가 아닙니다.");
        }
        return null;
    }
}
