package lotto.core.service;

import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoNumberDto;
import lotto.core.model.LottoNumber;

public class CreateBonusLottoNumberService {

    public LottoNumberDto create(String value, LottoDto winningLotto) {
        validateValue(value);

        LottoNumber number = new LottoNumber(parseInt(value));

        validateWinningLottoContains(winningLotto, number);

        return LottoNumberDto.modelOf(number);
    }

    private void validateValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("보너스 번호를 입력해주세요.");
        }
    }

    private Integer parseInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력해주세요.");
        }
    }

    private void validateWinningLottoContains(LottoDto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.numbers().contains(bonusNumber.value())) {
            throw new IllegalArgumentException("당첨 번호에 있는 번호는 보너스 번호로 입력할 수 없어요.");
        }
    }
}
