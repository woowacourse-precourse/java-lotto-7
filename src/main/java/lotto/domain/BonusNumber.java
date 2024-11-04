package lotto.domain;

import lotto.config.LottoConfig;

public record BonusNumber(int number) {

    public BonusNumber {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number < LottoConfig.START_NUMBER || number > LottoConfig.END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + LottoConfig.START_NUMBER + " 이상 " + LottoConfig.END_NUMBER + " 이하의 양의 정수만 입력 가능합니다.");
        }
    }
}
