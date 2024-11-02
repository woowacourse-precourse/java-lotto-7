package lotto.dto;

import static lotto.validator.LottoBonusNumberValidator.validateLottoBonusNumber;

public record BonusLottoNumber(
        int bonusLotto
) {
    public static BonusLottoNumber from(String inputBonusLottoNumber, WinningLottoNumbers winningLottoNumbers) {
        validateLottoBonusNumber(inputBonusLottoNumber, winningLottoNumbers);
        return new BonusLottoNumber(Integer.parseInt(inputBonusLottoNumber));
    }
}
