package lotto.model;

import lotto.dto.WinningNumberDto;

public class WinningNumber {
    private final Lotto lotto;
    private final int bonus;

    public WinningNumber(Lotto lotto, int bonus) {
        this.lotto = lotto;
        validateUniqueBonus(bonus);
        validateBonusRange(bonus);
        this.bonus = bonus;
    }

    private void validateUniqueBonus(int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복일 수 없습니다.");
        }
    }

    private void validateBonusRange(int bonus) {
        if (bonus < LottoIntConst.MIN_LOTTO_NUM.getValue() || bonus > LottoIntConst.MAX_LOTTO_NUM.getValue()) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 번호는 " + LottoIntConst.MIN_LOTTO_NUM.getValue() + "에서 "
                            + LottoIntConst.MAX_LOTTO_NUM.getValue() + "사이 여야 합니다."
            );
        }
    }

    public WinningNumberDto toWinningNumberDto() {
        return new WinningNumberDto(lotto, bonus);
    }
}
