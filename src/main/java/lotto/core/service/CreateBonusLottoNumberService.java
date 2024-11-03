package lotto.core.service;

import lotto.commons.numbers.Integers;
import lotto.core.constants.Error.BonusNumberError;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoNumberDto;
import lotto.core.model.LottoNumber;

public class CreateBonusLottoNumberService {

    public LottoNumberDto create(String value, LottoDto winningLotto) {
        validateValue(value);

        Integer intValue = Integers.parseIntOrThrow(value, BonusNumberError.INVALID_NUMBER_FORMAT);
        LottoNumber number = new LottoNumber(intValue);

        validateWinningLottoContains(winningLotto, number);

        return LottoNumberDto.modelOf(number);
    }

    private void validateValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(BonusNumberError.REQUIRED_NUMBER);
        }
    }

    private void validateWinningLottoContains(LottoDto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.numbers().contains(bonusNumber.value())) {
            throw new IllegalArgumentException(BonusNumberError.DUPLICATED_NUMBER);
        }
    }
}
