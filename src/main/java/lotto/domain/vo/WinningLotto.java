package lotto.domain.vo;

import static lotto.common.constant.ErrorMessages.*;

import lotto.domain.entity.Lotto;

public record WinningLotto(Lotto lotto, BonusNumber bonus) {

    public static WinningLotto of(Lotto lotto, String inputBonus) {
        BonusNumber bonus = new BonusNumber(inputBonus);
        validateDuplicate(lotto, bonus);
        return new WinningLotto(lotto, bonus);
    }

    private static void validateDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        LottoNumbers lottoNumbers = lotto.createLottoNumbers();
        if (lottoNumbers.hasNumber(bonusNumber.number())) {
            throw new IllegalArgumentException(DUPLICATED.toString());
        }
    }
}
