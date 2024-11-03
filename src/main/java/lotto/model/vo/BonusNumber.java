package lotto.model.vo;

import lotto.util.LottoUtils;

public record BonusNumber(int num) {

    private static final String MESSAGE = "보너스 번호는";

    public static BonusNumber fromString(String input) {
        LottoUtils.validatePositiveNumber(input, MESSAGE);
        int bonusNumber = Integer.parseInt(input);
        LottoUtils.validateNumberRange(bonusNumber, MESSAGE);
        return new BonusNumber(bonusNumber);
    }
}
